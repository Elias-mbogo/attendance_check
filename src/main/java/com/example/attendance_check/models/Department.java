package com.example.attendance_check.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Department {
    @Id
    private Integer id;
    private String names;
    AggregateReference<Company, Integer> company_id;
}
