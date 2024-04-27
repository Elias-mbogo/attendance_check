package com.example.attendance_check.controllers;

import com.example.attendance_check.models.dtos.AttendanceDetailsIds;
import com.example.attendance_check.models.dtos.AttendanceDetailsNames;
import com.example.attendance_check.services.AttendanceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @PostMapping("/attendance")
    public AttendanceDetailsIds postAttendance(@RequestBody AttendanceDetailsNames attendanceDetailsNames){
        return attendanceService.addNewAttendance(attendanceDetailsNames);
    }
}
