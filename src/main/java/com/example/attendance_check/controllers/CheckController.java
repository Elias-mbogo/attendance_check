package com.example.attendance_check.controllers;

import com.example.attendance_check.models.TimeLedger;
import com.example.attendance_check.models.dtos.CheckVisitor;
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
    public CheckVisitor postVisitorCheckIn(@RequestBody PeopleNationalid peopleNationalid){
        return checkService.getVisitorCheckIn(peopleNationalid);
    }
    //Check in laptop
    @PostMapping("/check_in_laptop")
    public TimeLedger postLaptopCheckIn(@RequestBody PeopleNationalid peopleNationalid){
        return checkService.getLaptopCheckIn(peopleNationalid);
    }
    //Check in key
    @PostMapping("/check_in_key")
    public TimeLedger postKeyCheckIn(@RequestBody PeopleNationalid peopleNationalid){
        return checkService.getKeyCheckIn(peopleNationalid);
    }

    @PostMapping("/check_out")
    public CheckVisitor checkOut(@RequestBody PeopleNationalid peopleNationalid){
        return checkService.getCheckOut(peopleNationalid);
    }
}
