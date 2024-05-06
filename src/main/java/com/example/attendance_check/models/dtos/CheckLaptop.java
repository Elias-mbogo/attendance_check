package com.example.attendance_check.models.dtos;

import lombok.Data;

@Data
public class CheckLaptop {
    private String username;
    private String modelType;
    private String date;
    private String time;
}
