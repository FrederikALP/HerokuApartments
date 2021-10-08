package com.example.herokuassignment.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="apartments")
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int number;

    @Column
    private int floor;

    @Column
    private int size;

    @Column
    private String familyName;
}
