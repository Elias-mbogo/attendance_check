package com.example.attendance_check.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Company {
    @Id
    private Integer id;
    private String names;
    AggregateReference<Premise, Integer> premise_id;
}
