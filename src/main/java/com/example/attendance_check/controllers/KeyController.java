package com.example.attendance_check.controllers;

import com.example.attendance_check.models.Key;
import com.example.attendance_check.services.KeyService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {
    private final KeyService keyService;

    public KeyController(KeyService keyService){
        this.keyService = keyService;
    }

    public Key postKey(Key key){
        return  keyService.addKey(key);
    }
}
