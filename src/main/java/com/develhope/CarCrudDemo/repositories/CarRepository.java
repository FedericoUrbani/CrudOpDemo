package com.develhope.CarCrudDemo.repositories;

import com.develhope.CarCrudDemo.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car,String> {
}
