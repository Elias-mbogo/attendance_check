package com.example.attendance_check.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckKey {
    private String username;
    private Integer number;
    private String date;
    private String time;
}
