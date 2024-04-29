package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Attendance;
import com.example.attendance_check.models.People;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
    Attendance findByPeopleId(AggregateReference<People, Integer> peopleId);
}
