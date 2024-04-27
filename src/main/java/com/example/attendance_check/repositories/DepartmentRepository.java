package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    Department findByNames(String names);
}
