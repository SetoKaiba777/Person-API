package com.kaibacorp.personapi.domain.service;

import com.kaibacorp.personapi.domain.exceptions.DontFoundException;
import com.kaibacorp.personapi.domain.exceptions.ServiceException;
import com.kaibacorp.personapi.domain.model.Person;
import com.kaibacorp.personapi.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person){
        exist(person);
        return personRepository.save(person);
    }

    public Person findById(long id){
        return personRepository.findById(id).orElseThrow(()->
                new DontFoundException("Don't Found this user"));
    }

    private void exist(Person user){
        Person personCpfExists = personRepository.findByCpf(user.getCpf());
        if(personCpfExists!=null && !personCpfExists.equals(user)){
            throw new ServiceException("This CPF already in data system");
        }
    }

}
