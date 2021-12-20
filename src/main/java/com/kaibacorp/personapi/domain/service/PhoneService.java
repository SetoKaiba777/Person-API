package com.kaibacorp.personapi.domain.service;

import com.kaibacorp.personapi.domain.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;
}
