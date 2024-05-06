package com.example.attendance_check.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckVisitor {
    private String username;
    private String company;
    private String date;
    private String time;
}
