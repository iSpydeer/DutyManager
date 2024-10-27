package com.ispydeer.DutyManager.duty;

import com.ispydeer.DutyManager.duty.priority.DutyPriority;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Duty {
    @Id
    @GeneratedValue
    private Integer id;

    private String assigner;
    private String supervisor;
    private String executor;
    private String description;
    private LocalDate startDate;
    private LocalDate targetDate;
    private DutyPriority priority;
    private Boolean isDone;
}
