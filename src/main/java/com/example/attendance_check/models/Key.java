package com.example.attendance_check.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
public class Key {
    @Id
    private Integer id;
    private Integer number;
    AggregateReference<People, Integer> people_id;

}
