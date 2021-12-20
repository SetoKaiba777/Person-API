package com.kaibacorp.personapi.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name",nullable = false)
    private String firstName;

    @Column(name = "Last_Name",nullable = false)
    private String lastName;

    @Column(name = "CPF",nullable = false, unique = true)
    private String cpf;


    @Column(name = "Birth_Date",nullable = false)
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Phone> phone;
}
