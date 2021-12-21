package com.kaibacorp.personapi.domain.service;

import com.kaibacorp.personapi.api.DTO.MessageResponseDTO;
import com.kaibacorp.personapi.api.DTO.PersonDTO;
import com.kaibacorp.personapi.api.mapper.PersonMapper;
import com.kaibacorp.personapi.domain.exceptions.DontFoundException;
import com.kaibacorp.personapi.domain.exceptions.ServiceException;
import com.kaibacorp.personapi.domain.model.Person;
import com.kaibacorp.personapi.domain.model.Phone;
import com.kaibacorp.personapi.domain.repository.PersonRepository;
import com.kaibacorp.personapi.domain.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    private PersonRepository personRepository;

    private PhoneRepository phoneRepository;

    public MessageResponseDTO save(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person personCpfExists = personRepository.findByCpf(personToSave.getCpf());
        if(personCpfExists!=null && !personCpfExists.equals(personToSave)){
            throw new ServiceException("This CPF already in data system");
        }
        verify(personToSave);
        var savedPerson = personRepository.save(personToSave);
        return messageResponse("Created Person with id " + savedPerson.getId());
    }

    public MessageResponseDTO update(Long id,PersonDTO personDTO){
        verifyByid(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        personToUpdate.setId(id);
        Person personCpfExists = personRepository.findByCpf(personToUpdate.getCpf());
        if(personCpfExists!=null && personCpfExists.getId() != id){
            throw new ServiceException("This CPF already in data system");
        }
        verify(personToUpdate);
        personRepository.save(personToUpdate);
        return messageResponse("Updated Person with id " + id);
    }

    public List<PersonDTO> getAll(){
        var allPeople =  personRepository.findAll();
        return allPeople.stream().
                map(personMapper::toDTO).
                collect(Collectors.toList());
    }

    public void delete(long id){
        verifyByid(id);
        personRepository.deleteById(id);
    }

    public PersonDTO findById(long id){
        PersonDTO personTofind =  personMapper.toDTO(verifyByid(id));
        return personTofind;
    }


    private MessageResponseDTO messageResponse(String msg){
        return MessageResponseDTO.builder().
                message(msg).
                build();
    }

    private Person verifyByid(Long id){
        return personRepository.findById(id).orElseThrow(()->
                new DontFoundException("Don't found Person with id "+id));
    }

    private void verify(Person person){
       if(person.getPhones().size() == 0){
            throw new ServiceException("The Field Phones can't be null!");
        }
       else if(person.getPhones().size() > 0){
            for (Phone phone : person.getPhones()){
                if(phoneRepository.findByNumber(phone.getNumber())!=null &&
                        phoneRepository.findByNumber(phone.getNumber()).getId()!= phone.getId()){
                    throw new ServiceException("The phone number " + phone.getNumber()+
                            " already in data system");
                }
                if(phone.getType()==null){
                    throw new ServiceException("Phone Type can't be null");
                }else if(phone.getNumber()==null){
                    throw new ServiceException("Phone Number can't be null");
                }
            }
        }
    }

}
