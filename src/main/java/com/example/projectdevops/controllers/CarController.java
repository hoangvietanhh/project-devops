package com.example.projectdevops.controllers;

import com.example.projectdevops.models.Car;
import com.example.projectdevops.services.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
@Api(value = "Car Inventory Management", protocols = "http")
public class CarController {


    @Autowired
    private CarService mService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "Save a car into the Car Inventory", response = Car.class,
            code = 200, /* hidden = true, */ notes = "Don't include carId in the request body")
    public Car addCar(@RequestBody Car bicycle) {
        return mService.addCar(bicycle);
    }

    @GetMapping(value = "/get/{carId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found the car by id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the car inventory"),
            @ApiResponse(code = 403, message = "Accessing the car inventory you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The car detail you were trying to reach is not found")
    })
    public Car findCarByID(@PathVariable("carId") Integer carId) {
        return mService.findCarByID(carId);
    }

    @GetMapping(value = "/get-car")
    public Iterable<Car> findAllCar() {
        return mService.getAllCar();
    }

    @PutMapping(value = "/update/{carId}/{price:.+}")
    public Car updateCarPrice(@PathVariable("carId") Integer carId,
                              @PathVariable("price") double updatedPrice) {
        return mService.updateCarPrice(carId, updatedPrice);
    }

    @DeleteMapping(value = "/delete/{carId}")
    public void deleteCar(@PathVariable("carId") Integer carId) {
        mService.deleteCar(carId);
    }
}
