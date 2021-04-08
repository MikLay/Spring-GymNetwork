package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.dto.specifications.WorkoutSpec;
import com.spp.gym_network.mainservice.exception.EntityNotFoundException;
import com.spp.gym_network.mainservice.exception.WorkoutProvidedDataException;
import com.spp.gym_network.mainservice.model.client.SubscriptionEntity;
import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import com.spp.gym_network.mainservice.model.user.ERoles;
import com.spp.gym_network.mainservice.model.workout.WorkoutEntity;
import com.spp.gym_network.mainservice.repository.*;
import com.spp.gym_network.mainservice.security.CustomUserDetails;
import com.spp.gym_network.mainservice.service.WorkoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DefaultWorkoutService implements WorkoutService {
    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    CoachRepository coachRepository;

    @Autowired
    GymRepository gymRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Page<WorkoutEntity> findMyWorkouts(CustomUserDetails user, WorkoutSpec spec, Pageable page) {
        List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        Specification<WorkoutEntity> specId = Specification.where(spec).and((root, query, cb) -> {
            ArrayList<Predicate> predicates = new ArrayList<>();
            if (roles.contains(ERoles.ROLE_CLIENT.name())) {
                predicates.add(cb.equal(root.get("client").get("id"), user.getId()));
            } else if (roles.contains(ERoles.ROLE_COACH.name())) {
                predicates.add(cb.equal(root.get("coach").get("id"), user.getId()));
            } else if (roles.contains(ERoles.ROLE_MANAGER.name())) {
                predicates.add(cb.equal(root.get("gym").get("id"), user.getId()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });

        return workoutRepository.findAll(specId, page);
    }

    @Override
    public WorkoutEntity createWorkout(Long clientId, Long coachId, Long gymId, Timestamp startTime, Timestamp endTime) {
        WorkoutEntity workout = new WorkoutEntity();

        // Check if startTime < endTime
        if (endTime.after(startTime)) {
            workout.setStartTime(startTime);
            workout.setEndTime(endTime);
        } else {
            throw new WorkoutProvidedDataException("Wrong time");
        }


        // Check Gym existence
        Optional<GymEntity> gym = gymRepository.findById(gymId);
        gym.ifPresentOrElse(workout::setGym, () -> {
            throw new EntityNotFoundException("Gym with id: " + gymId + " not found");
        });

        // For workout with coach
        if (coachId != null) {
            Optional<CoachEntity> coach = coachRepository.findById(coachId);
            coach.ifPresentOrElse((coachEntity) -> coachEntity.getTimetables().stream()
                    // Check if there are timetables that fit workout`s time in selected gym
                    .filter(timetableEntity -> timetableEntity.getGym().getId().equals(gymId))
                    .filter(timetableEntity -> startTime.after(timetableEntity.getStartTime())
                            && startTime.before(timetableEntity.getEndTime())
                            && endTime.after(timetableEntity.getStartTime())
                            && endTime.before(timetableEntity.getEndTime()))
                    .findAny()
                    .ifPresentOrElse(timetableEntity -> {
                                workout.setCoach(coachEntity);
                                workout.addSurcharge(coachEntity.getPayment());
                            },
                            () -> {
                                throw new WorkoutProvidedDataException("Coach doesn`t work at provided time gap");
                            }), () -> {
                throw new EntityNotFoundException("Coach with id: " + coachId + " not found");
            });

        }

        // Check for client subscription and if it fit`s workout`s time
        clientRepository.findById(clientId).ifPresent((clientEntity) -> {
            workout.setClient(clientEntity);
            List<SubscriptionEntity> subscriptions = clientEntity.getSubscriptions().stream()
                    .filter(subscriptionEntity ->
                            startTime.after(subscriptionEntity.getStartingDatetime())
                                    && startTime.before(subscriptionEntity.getExpiringDatetime())
                                    && endTime.after(subscriptionEntity.getStartingDatetime())
                                    && endTime.before(subscriptionEntity.getExpiringDatetime())
                    ).collect(Collectors.toList());
            if (subscriptions.isEmpty()) {
                throw new WorkoutProvidedDataException("Client doesn't have active subscriptions");
            } else {
                subscriptions.stream().filter(subscriptionEntity ->
                        startTime.toLocalDateTime().toLocalTime().isAfter(subscriptionEntity.getBeginningTime().toLocalTime())
                                && startTime.toLocalDateTime().toLocalTime().isBefore(subscriptionEntity.getEndingTime().toLocalTime())
                                && endTime.toLocalDateTime().toLocalTime().isAfter(subscriptionEntity.getBeginningTime().toLocalTime())
                                && startTime.toLocalDateTime().toLocalTime().isBefore(subscriptionEntity.getEndingTime().toLocalTime()))
                        .findAny().ifPresentOrElse(subscriptionEntity -> {
                }, () -> workout.addSurcharge(gym.get().getFine()));
            }
        });

        return workoutRepository.save(workout);
    }

    @Override
    public Boolean verifyWorkout(Long managerId, Long workoutId) {
        WorkoutEntity workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new EntityNotFoundException("No workout with id:" + workoutId));
        if (managerRepository.existsByIdAndGyms_Id(managerId, workoutId)) {
            workout.setVerified(true);
        }
        return workoutRepository.save(workout).isVerified();

    }
}
