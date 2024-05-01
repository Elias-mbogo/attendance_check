package com.example.attendance_check.controllers;

import com.example.attendance_check.models.dtos.Check;
import com.example.attendance_check.models.dtos.PeopleNationalid;
import com.example.attendance_check.services.CheckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
    private final CheckService checkService;

    public CheckController(CheckService checkService){
        this.checkService = checkService;
    }

    //CHECK INS
    //Check in visitor
    @PostMapping("/check_in_visitor")
    public Check checkIn(@RequestBody PeopleNationalid peopleNationalid){
        return checkService.getVisitorCheckIn(peopleNationalid);
    }

    @PostMapping("/check_out")
    public Check checkOut(@RequestBody PeopleNationalid peopleNationalid){
        return checkService.getCheckOut(peopleNationalid);
    }
}
