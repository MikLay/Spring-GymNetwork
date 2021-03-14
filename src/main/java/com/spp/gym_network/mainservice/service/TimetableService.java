package com.spp.gym_network.mainservice.service;

import com.spp.gym_network.mainservice.model.coach.TimetableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;

public interface TimetableService {
    Page<TimetableEntity> findMyTimetables(Long id, Pageable page);

    TimetableEntity createTimetable(Long coachId, Long gymId, Timestamp startTime, Timestamp endTime);
}
