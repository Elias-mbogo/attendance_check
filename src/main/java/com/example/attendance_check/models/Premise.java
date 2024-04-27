package com.example.attendance_check.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Premise {
    @Id
    private Integer id;
    private String names;
}
