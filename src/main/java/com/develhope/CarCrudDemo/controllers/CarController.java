package com.develhope.CarCrudDemo.controllers;

import com.develhope.CarCrudDemo.entites.Car;
import com.develhope.CarCrudDemo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/allcars")
    public List<Car> findAllCars() {
        return karRepository.findAll();
    }

    @GetMapping("findcar/{id}")
    public Optional<Car> findSingleCar(@PathVariable String id) {

        if (karRepository.existsById(id)) {
            return karRepository.findById(id);
        } else {
            return null;

        }
    }

    @PutMapping("/{id}/{type}")
    public Car changeType(@PathVariable String id,
                          @PathVariable String type,
                          @RequestBody Car car) {

        if (karRepository.existsById(id)) {
            car.setType(type);
            return karRepository.save(car);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus DeleteCarbyId(@PathVariable String id) {
        if (karRepository.existsById(id)) {
            karRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        } else {
            return HttpStatus.CONFLICT;
        }
    }
}

