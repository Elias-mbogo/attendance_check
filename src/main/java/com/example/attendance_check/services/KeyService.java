package com.example.attendance_check.services;

import com.example.attendance_check.models.Key;
import com.example.attendance_check.repositories.KeyRepository;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
    private final KeyRepository keyRepository;

    public KeyService(KeyRepository keyRepository){
        this.keyRepository = keyRepository;
    }

    public Key addKey(Key key){
        return keyRepository.save(key);
    }
}
