package com.develhope.CarCrudDemo.repositories;

import com.develhope.CarCrudDemo.entites.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String> {
}
