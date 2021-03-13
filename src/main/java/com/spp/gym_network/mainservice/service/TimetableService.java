package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.dto.TimetableDTO;
import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TimetableService {
    Page<TimetableEntity> findMyTimetables(Long id, Pageable page);

    TimetableEntity createTimetable(Long id, TimetableDTO timetable);
}
