package com.codecool.wuff.wuffproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Dog {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String breed;
    private String ownerName;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String picture;

}
