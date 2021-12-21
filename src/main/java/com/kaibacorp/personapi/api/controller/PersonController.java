package com.kaibacorp.personapi.api.controller;

import com.kaibacorp.personapi.api.DTO.MessageResponseDTO;
import com.kaibacorp.personapi.api.DTO.PersonDTO;
import com.kaibacorp.personapi.domain.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findPerson(@PathVariable long id){
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        personService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO postPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.save(personDTO);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody PersonDTO personDTO){
        return personService.update(id,personDTO);
    }


}
