package com.develhope.CarCrudDemo.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    private String id;

    private String modelName;

    private String type;

}
