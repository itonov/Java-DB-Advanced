package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.RaceEntryWrapperXMLImportDto;
import org.softuni.mostwanted.domain.models.Car;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.api.CarService;
import org.softuni.mostwanted.services.api.RaceEntryService;
import org.softuni.mostwanted.services.api.RacerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceEntryController {

    private final Parser parser;
    private final RaceEntryService raceEntryService;
    private final CarService carService;
    private final RacerService racerService;

    public RaceEntryController(@Qualifier(value = "XMLParser") Parser parser,
                               RaceEntryService raceEntryService,
                               CarService carService,
                               RacerService racerService) {
        this.parser = parser;
        this.raceEntryService = raceEntryService;
        this.carService = carService;
        this.racerService = racerService;
    }

    public String importDataFromXML(String read) {
        StringBuilder sb = new StringBuilder();

        try {
            RaceEntryWrapperXMLImportDto raceEntries = this.parser.read(RaceEntryWrapperXMLImportDto.class, read);
            raceEntries.getRaceEntries()
                    .forEach(re -> {
                        Car car = this.carService.findById(re.getCarId());
                        Racer racer = this.racerService.findByName(re.getRacer());
                        if (car != null && racer != null) {
                            sb.append(String.format("Successfully imported RaceEntry - %d.", this.raceEntryService.save(re)))
                                    .append(System.lineSeparator());
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
