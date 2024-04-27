package com.example.attendance_check.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceDetailsIds {
    private Integer premise_id;
    private Integer company_id;
    private Integer companydepartment_id;
    private Integer department_id;
    private Integer people_id;
}
