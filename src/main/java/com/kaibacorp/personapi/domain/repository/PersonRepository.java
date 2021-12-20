package com.kaibacorp.personapi.domain.repository;

import com.kaibacorp.personapi.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    public Person findByCpf(String cpf);
}
