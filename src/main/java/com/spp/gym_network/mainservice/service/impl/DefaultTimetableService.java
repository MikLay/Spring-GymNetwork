package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.exception.EntityNotFoundException;
import com.spp.gym_network.mainservice.model.coach.CoachEntity;
import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import com.spp.gym_network.mainservice.repository.CoachRepository;
import com.spp.gym_network.mainservice.repository.GymRepository;
import com.spp.gym_network.mainservice.repository.TimetableRepository;
import com.spp.gym_network.mainservice.service.TimetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
public class DefaultTimetableService implements TimetableService {

    @Autowired
    TimetableRepository timetableRepository;

    @Autowired
    CoachRepository coachRepository;

    @Autowired
    GymRepository gymRepository;

    @Override
    public Page<TimetableEntity> findMyTimetables(Long id, Pageable page) {
        return timetableRepository.findAllByCoach_Id(id, page);
    }

    @Override
    public TimetableEntity createTimetable(Long coachId, Long gymId, Timestamp startTime, Timestamp endTime) {
        //TODO: add if there is no timetable at this time for this coach.
        GymEntity gym = gymRepository.getOne(gymId);
        CoachEntity coach = coachRepository.getOne(coachId);
        TimetableEntity timetable = new TimetableEntity();
        timetable.setGym(gym);
        timetable.setCoach(coach);
        timetable.setStartTime(startTime);
        timetable.setEndTime(endTime);
        try {
            return timetableRepository.save(timetable);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new EntityNotFoundException(e.getMessage());
        }
    }


}
