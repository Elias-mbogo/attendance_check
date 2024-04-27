package com.example.attendance_check.models;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class People {
    @Id
    private Integer id;
    private Integer nationalid;
    private String username;
    private String email;
}
