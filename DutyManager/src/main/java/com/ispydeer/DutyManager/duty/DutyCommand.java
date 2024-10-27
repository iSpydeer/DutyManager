package com.ispydeer.DutyManager.duty;

import com.ispydeer.DutyManager.duty.priority.DutyPriority;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DutyCommand {

    private Integer id;

    private String assigner;

    @Size(max = 30)
    private String supervisor;

    @Size(min = 3, max = 30)
    private String executor;

    @NotEmpty
    @Size(max = 255)
    private String description;

    private LocalDate startDate;
    private LocalDate targetDate;
    private DutyPriority priority;
    private Boolean isDone;
}
