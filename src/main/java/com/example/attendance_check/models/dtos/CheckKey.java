package com.example.attendance_check.models.dtos;

import lombok.Data;

@Data
public class CheckKey {
    private String username;
    private String number;
    private String date;
    private String time;
}
