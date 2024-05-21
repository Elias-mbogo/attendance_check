package com.example.attendance_check.controllers;

import com.example.attendance_check.models.dtos.KeyDetails;
import com.example.attendance_check.services.KeyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
    private final KeyService keyService;

    public KeyController(KeyService keyService){
        this.keyService = keyService;
    }

    @PostMapping("/key")
    public KeyDetails postKey(KeyDetails key){
        return  keyService.addKey(key);
    }
}
