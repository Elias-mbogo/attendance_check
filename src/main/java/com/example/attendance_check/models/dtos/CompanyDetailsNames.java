package com.example.attendance_check.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDetailsNames {
    private String premise_name;
    private String company_name;
    private String companydepartment_name;
    private String department_name;
}
