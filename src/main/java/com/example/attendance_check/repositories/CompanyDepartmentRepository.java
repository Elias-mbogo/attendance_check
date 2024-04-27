package com.example.attendance_check.repositories;

import com.example.attendance_check.models.CompanyDepartment;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDepartmentRepository extends CrudRepository<CompanyDepartment, Integer> {
    CompanyDepartment findByNames(String names);
}
