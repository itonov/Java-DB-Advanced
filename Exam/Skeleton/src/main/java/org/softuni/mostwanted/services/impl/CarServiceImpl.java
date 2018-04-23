package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.CarJSONImportDto;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.services.api.CarService;
import org.softuni.mostwanted.services.api.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final RacerService racerService;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          RacerService racerService) {
        this.carRepository = carRepository;
        this.racerService = racerService;
    }

    @Override
    public Car findByBrandModelAndYear(String brand, String model, int year) {
        return this.carRepository.findByBrandAndModelAndYearOfProduction(brand, model, year);
    }

    @Override
    public void create(CarJSONImportDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setMaxSpeed(carDto.getMaxSpeed());
        car.setZeroToSixty(carDto.getZeroToSixty());
        car.setPrice(carDto.getPrice());
        car.setYearOfProduction(carDto.getYearOfProduction());
        car.setRacer(this.racerService.findByName(carDto.getRacerName()));
        this.carRepository.saveAndFlush(car);
    }

    @Override
    public Car findById(Integer carId) {
        return this.carRepository.findOne(carId);
    }
}
