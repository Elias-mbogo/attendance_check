package com.example.attendance_check.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class CompanyDepartment {
    @Id
    private Integer id;
    private String names;
    AggregateReference<Company, Integer> company_id;
}
