package com.kaibacorp.personapi.api.mapper;

import com.kaibacorp.personapi.api.DTO.PersonDTO;
import com.kaibacorp.personapi.domain.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate",source = "birthDate", dateFormat = "dd-MM-yyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}