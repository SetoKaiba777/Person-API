package com.kaibacorp.personapi.service;

import com.kaibacorp.personapi.api.DTO.MessageResponseDTO;
import com.kaibacorp.personapi.api.DTO.PersonDTO;
import com.kaibacorp.personapi.domain.model.Person;
import com.kaibacorp.personapi.domain.repository.PersonRepository;
import com.kaibacorp.personapi.domain.repository.PhoneRepository;
import com.kaibacorp.personapi.domain.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.kaibacorp.personapi.utils.PersonUtils.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = MessageResponseDTO.builder().
                message("Created Person with id " + expectedSavedPerson.getId())
                .build();

        MessageResponseDTO  succesMessage = personService.save(personDTO);
        Assertions.assertEquals(expectedSuccessMessage,succesMessage);

    }
}
