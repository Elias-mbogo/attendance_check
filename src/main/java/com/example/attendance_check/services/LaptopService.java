package com.example.attendance_check.services;

import com.example.attendance_check.models.Laptop;
import com.example.attendance_check.models.People;
import com.example.attendance_check.models.dtos.LaptopDetails;
import com.example.attendance_check.repositories.LaptopRepository;
import com.example.attendance_check.repositories.PeopleRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;
    private final PeopleRepository peopleRepository;

    public LaptopService(LaptopRepository laptopRepository, PeopleRepository peopleRepository){
        this.laptopRepository = laptopRepository;
        this.peopleRepository = peopleRepository;
    }

    public LaptopDetails addLaptop(LaptopDetails laptop){
        People people = peopleRepository.findByNationalid(laptop.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());

        laptopRepository.save(new Laptop(null, laptop.getModelType(), laptop.getSerialNo(), peopleId));
        return laptop;
    }
}
