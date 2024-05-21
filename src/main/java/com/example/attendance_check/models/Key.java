package com.example.attendance_check.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Data
@AllArgsConstructor
public class Key {
    @Id
    private Integer id;
    private Integer number;
    AggregateReference<People, Integer> peopleId;

}
