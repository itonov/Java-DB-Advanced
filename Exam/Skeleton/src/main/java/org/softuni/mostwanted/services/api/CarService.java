package org.softuni.mostwanted.services.api;

import org.softuni.mostwanted.domain.dtos.CarJSONImportDto;
import org.softuni.mostwanted.domain.models.Car;

public interface CarService {

    Car findByBrandModelAndYear(String brand, String model, int year);

    void create(CarJSONImportDto carDto);

    Car findById(Integer carId);
}
