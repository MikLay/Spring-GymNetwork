package com.spp.gym_network.mainservice.model.coach;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spp.gym_network.mainservice.model.gym.GymEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "timetable")
public class TimetableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private CoachEntity coach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id")
    private GymEntity gym;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TimetableEntity that = (TimetableEntity) o;
        return Objects.equals(coach, that.coach) &&
                Objects.equals(gym, that.gym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, gym);
    }
}
