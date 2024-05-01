package com.example.attendance_check.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Laptop {
    @Id
    private Integer id;
    private String modelType;
    private String serialNo;
    AggregateReference<People, Integer> people_id;
}
