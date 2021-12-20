package com.kaibacorp.personapi.domain.repository;

import com.kaibacorp.personapi.domain.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
