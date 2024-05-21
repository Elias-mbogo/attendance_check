package com.example.attendance_check.controllers;

import com.example.attendance_check.models.Laptop;
import com.example.attendance_check.models.dtos.LaptopDetails;
import com.example.attendance_check.services.LaptopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {
    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService){
        this.laptopService = laptopService;
    }

    @PostMapping("/laptop")
    public LaptopDetails postLaptop(@RequestBody LaptopDetails laptop){
        return laptopService.addLaptop(laptop);
    }
}
