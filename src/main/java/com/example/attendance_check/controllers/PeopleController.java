package com.example.attendance_check.controllers;

import com.example.attendance_check.models.People;
import com.example.attendance_check.models.dtos.PeopleNationalid;
import com.example.attendance_check.services.PeopleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService){
        this.peopleService = peopleService;
    }

    @PostMapping("/people")
    public People postPerson(@RequestBody People people){
        return peopleService.addPerson(people);
    }

    @PostMapping("/peopleName")
    public People getPerson(@RequestBody PeopleNationalid peopleNationalid){
        return peopleService.getPersonByNationalId(peopleNationalid.getNationalid());
    }

}
