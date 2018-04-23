package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.CarJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.api.CarService;
import org.softuni.mostwanted.services.api.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class CarController {

    private final CarService carService;
    private final RacerService racerService;
    private final Parser parser;

    @Autowired
    public CarController(CarService carService,
                         RacerService racerService,
                         @Qualifier(value = "JSONParser") Parser parser) {
        this.carService = carService;
        this.racerService = racerService;
        this.parser = parser;
    }

    public String importDataFromJSON(String read) {
        StringBuilder sb = new StringBuilder();

        try {
            CarJSONImportDto[] carDtos = this.parser.read(CarJSONImportDto[].class, read);
            Arrays.stream(carDtos)
                    .forEach(c -> {
                        if (ValidationUtil.isValid(c) || this.racerService.findByName(c.getRacerName()) != null) {
                            if (this.carService.findByBrandModelAndYear(c.getBrand(), c.getModel(), c.getYearOfProduction()) == null) {
                                this.carService.create(c);
                                sb.append(String.format("Successfully imported Car - %s %s @ %d.",
                                        c.getBrand(), c.getModel(), c.getYearOfProduction()))
                                        .append(System.lineSeparator());
                            } else {
                                sb.append("Error: Duplicate Data!").append(System.lineSeparator());
                            }
                        } else {
                            sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                        }
                    });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
