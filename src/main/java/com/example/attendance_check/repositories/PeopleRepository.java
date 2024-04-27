package com.example.attendance_check.repositories;

import com.example.attendance_check.models.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {
    People findByNationalid(Integer nationalid);
}
