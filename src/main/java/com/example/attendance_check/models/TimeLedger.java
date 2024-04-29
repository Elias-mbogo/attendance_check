package com.example.attendance_check.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class TimeLedger {
    @Id
    private Integer id;
    private String dateCheckedIn;
    private String dateCheckedOut;
    private boolean status;
    private String timeCheckedIn;
    private String timeCheckedOut;
    AggregateReference<Attendance, Integer> attendance_id;
}
