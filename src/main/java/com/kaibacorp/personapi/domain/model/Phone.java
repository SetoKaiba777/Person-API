package com.kaibacorp.personapi.domain.model;

import com.kaibacorp.personapi.domain.enums.PhoneType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type",nullable = false)
    private PhoneType type;

    @Column(name = "Number",nullable = false)
    private String number;
}
