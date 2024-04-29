package com.example.attendance_check.controllers;

import com.example.attendance_check.models.TimeLedger;
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

    @PostMapping("/check")
    public TimeLedger getCheckResults(@RequestBody PeopleNationalid peopleNationalid){
        return  checkService.getCheckIn(peopleNationalid);
    }
}
