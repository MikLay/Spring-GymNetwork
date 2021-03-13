package com.spp.gym_network.mainservice.service.impl;

import com.spp.gym_network.mainservice.dto.TimetableDTO;
import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import com.spp.gym_network.mainservice.repository.TimetableRepository;
import com.spp.gym_network.mainservice.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultTimetableService implements TimetableService {

    @Autowired
    TimetableRepository repository;

    @Override
    public Page<TimetableEntity> findMyTimetables(Long id, Pageable page) {
        return repository.findAllByCoach_Id(id, page);
    }

    @Override
    public TimetableEntity createTimetable(Long id, TimetableDTO timetable) {
        return null;
    }
}
