package com.example.attendance_check.services;

import com.example.attendance_check.models.People;
import com.example.attendance_check.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public People addPerson(People person){
        return peopleRepository.save(person);
    }

    public People getPersonByNationalId(Integer nationalid){
        return  peopleRepository.findByNationalid(nationalid);
    }
}
