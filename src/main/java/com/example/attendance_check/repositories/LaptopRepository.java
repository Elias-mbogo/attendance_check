package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Laptop;
import com.example.attendance_check.models.People;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
    Laptop findByPeopleId(AggregateReference<People, Integer> peopleId);
}
