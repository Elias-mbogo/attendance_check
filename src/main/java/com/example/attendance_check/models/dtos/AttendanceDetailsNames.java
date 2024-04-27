package com.example.attendance_check.models.dtos;

import lombok.Data;

@Data
public class AttendanceDetailsNames {
    private String premise_name;
    private String company_name;
    private String companydepartment_name;
    private String department_name;
    private Integer people_nationalid;
}
