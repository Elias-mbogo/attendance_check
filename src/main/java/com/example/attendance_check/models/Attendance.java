package com.example.attendance_check.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class Attendance {
    @Id
    private Integer id;
    AggregateReference<Premise, Integer> premise_id;
    AggregateReference<Company, Integer> company_id;
    AggregateReference<CompanyDepartment, Integer> companydepartment_id;
    AggregateReference<Department, Integer> department_id;
    AggregateReference<People, Integer> peopleId;
}