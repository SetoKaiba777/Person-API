package com.kaibacorp.personapi.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name",nullable = false)
    private String firstName;

    @Column(name = "Last_Name",nullable = false)
    private String lastName;

    @Column(name = "CPF", unique = true,nullable = false)
    private String cpf;


    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
