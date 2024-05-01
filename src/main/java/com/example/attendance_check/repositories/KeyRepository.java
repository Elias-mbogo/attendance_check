package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Key;
import com.example.attendance_check.models.People;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;

public interface KeyRepository extends CrudRepository<Key, Integer> {
    Key findByPeopleId(AggregateReference<People, Integer> peopleId);
}
