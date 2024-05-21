package com.example.attendance_check.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckLaptop {
    private String username;
    private String modelType;
    private String date;
    private String time;
}
