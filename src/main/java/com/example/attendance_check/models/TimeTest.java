package com.example.attendance_check.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class TimeTest {
    @Id
    private Integer id;
    private String dateCheckedIn;
    private String timeCheckedIn;
}
