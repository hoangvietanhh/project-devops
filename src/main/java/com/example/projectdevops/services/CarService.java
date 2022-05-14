package com.example.projectdevops.services;

import com.example.projectdevops.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository mRepository;

    public Car addCar(Car car) {
        return mRepository.save(car);
    }

    public Car findCarByID(Integer carId) {
        return mRepository.findById(carId).get();
    }

    public Car updateCarPrice(Integer carId, double updatedPrice) {
        Car temp =  mRepository.findById(carId).get();
        temp.setPrice(updatedPrice);
        return mRepository.save(temp);
    }

    public void deleteCar(Integer carId) {
        mRepository.deleteById(carId);
    }

    public Iterable<Car> getAllCar(){
        return mRepository.findAll();
    }
}
