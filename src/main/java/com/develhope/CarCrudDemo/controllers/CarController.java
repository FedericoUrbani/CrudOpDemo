package com.develhope.CarCrudDemo.controllers;

import com.develhope.CarCrudDemo.entites.Car;
import com.develhope.CarCrudDemo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository karRepository;

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        car.setId(null);
        return karRepository.save(car);
    }

    @GetMapping("")
    public List<Car> findAllCars() {
        return karRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Car> findSingleCar(@PathVariable String id) {

        if (karRepository.existsById(id)) {
            return karRepository.findById(id);
        } else {
            return null;

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") String id, @RequestBody Car car) {
        Optional<Car> optionalCar = karRepository.findById(id);
        if (optionalCar != null) {
            car.setId(id);
            karRepository.save(car);
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCarbyId(@PathVariable String id) {
        if (karRepository.existsById(id)) {
            karRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        } else {
            return HttpStatus.CONFLICT;
        }
    }
}

