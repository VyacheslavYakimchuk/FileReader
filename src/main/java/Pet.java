package com.springapp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by TeSla on 13.02.2015.
 */

@Data
@Table
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String nickName;
    String species;
    int age;

    @ManyToOne
    @JoinColumn
    People people;


}
