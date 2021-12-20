package com.kaibacorp.personapi.api.controller;

import com.kaibacorp.personapi.api.DTO.MessageResponseDTO;
import com.kaibacorp.personapi.domain.model.Person;
import com.kaibacorp.personapi.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO postPerson(@Valid @RequestBody Person person){
        personService.save(person);
        return MessageResponseDTO.builder().
                message("Created Person with id " + person.getId()).
                build();
    }
}
