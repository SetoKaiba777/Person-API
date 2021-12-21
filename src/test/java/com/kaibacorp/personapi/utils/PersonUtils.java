package com.kaibacorp.personapi.utils;

import com.kaibacorp.personapi.api.DTO.PersonDTO;
import com.kaibacorp.personapi.domain.model.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String FIRST_NAME = "Caio";
    private static final String LAST_NAME = "Oliveira";
    private static final String CPF_NUMBER = "091.946.376-28";
    public static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1994,10,1);

    public static PersonDTO createFakeDTO(){
        return PersonDTO.builder().
                firstName(FIRST_NAME).
                lastName(LAST_NAME).
                cpf(CPF_NUMBER).
                birthDate("01-12-1994").
                phones(Collections.singletonList(PhoneUtils.createFakePhoneDTO())).
                build();
    }
    public static Person createFakeEntity(){
        return Person.builder().
                id(PERSON_ID).
                firstName(FIRST_NAME).
                lastName(LAST_NAME).
                cpf(CPF_NUMBER).
                birthDate(BIRTH_DATE).
                phones(Collections.singletonList(PhoneUtils.createFakeEntity())).
                build();
    }
}
