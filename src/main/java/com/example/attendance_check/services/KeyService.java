package com.example.attendance_check.services;

import com.example.attendance_check.models.Key;
import com.example.attendance_check.models.People;
import com.example.attendance_check.models.dtos.KeyDetails;
import com.example.attendance_check.repositories.KeyRepository;
import com.example.attendance_check.repositories.PeopleRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    private final KeyRepository keyRepository;
    private final PeopleRepository peopleRepository;

    public KeyService(KeyRepository keyRepository, PeopleRepository peopleRepository){
        this.keyRepository = keyRepository;
        this.peopleRepository = peopleRepository;
    }

    public KeyDetails addKey(KeyDetails key){
        People people = peopleRepository.findByNationalid(key.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());

        keyRepository.save(new Key(null, key.getNumber(), peopleId));

        return key;
    }
}
