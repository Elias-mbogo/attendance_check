package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    Company findByNames(String names);
}
