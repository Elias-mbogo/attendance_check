package com.example.attendance_check.controllers;

import com.example.attendance_check.models.dtos.CompanyDetailsNames;
import com.example.attendance_check.services.CompanyDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyDetailsController {
    private final CompanyDetailsService companyDetailsService;

    public CompanyDetailsController(CompanyDetailsService companyDetailsService){
        this.companyDetailsService = companyDetailsService;
    }

    @PostMapping("/company_details")
    public CompanyDetailsNames getCompanyDetailsIds(@RequestBody CompanyDetailsNames companyDetailsNames){
        return companyDetailsService.getCompanyIds(companyDetailsNames);
    }
}
