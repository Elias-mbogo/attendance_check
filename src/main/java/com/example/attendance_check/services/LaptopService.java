package com.example.attendance_check.services;

import com.example.attendance_check.models.Laptop;
import com.example.attendance_check.repositories.LaptopRepository;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    public Laptop addLaptop(Laptop laptop){
        return laptopRepository.save(laptop);
    }
}
