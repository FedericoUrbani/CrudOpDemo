package com.develhope.CarCrudDemo.repositories;

import com.develhope.CarCrudDemo.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, String> {

    @Override
    Optional<Car> findById(String s);
}
