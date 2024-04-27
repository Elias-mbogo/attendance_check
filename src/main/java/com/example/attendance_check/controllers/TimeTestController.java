package com.example.attendance_check.controllers;

import com.example.attendance_check.models.TimeTest;
import com.example.attendance_check.services.TimeTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeTestController {
    private final TimeTestService timeTestService;

    public TimeTestController(TimeTestService timeTestService){
        this.timeTestService = timeTestService;
    }

    @GetMapping("/time_test")
    public TimeTest getTime(){
        return  timeTestService.getCurrentTime();
    }
}
