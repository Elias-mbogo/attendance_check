package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Premise;
import org.springframework.data.repository.CrudRepository;

public interface PremiseRepository extends CrudRepository<Premise, Integer> {
    Premise findByNames(String names);
}
