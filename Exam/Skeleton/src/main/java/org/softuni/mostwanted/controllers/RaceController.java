package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.RaceWrapperXMLImportDto;
import org.softuni.mostwanted.domain.dtos.RaceXMLImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.api.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class RaceController {

    private final RaceService raceService;
    private final Parser parser;

    @Autowired
    public RaceController(RaceService raceService,
                          @Qualifier(value = "XMLParser") Parser parser) {
        this.raceService = raceService;
        this.parser = parser;
    }

    public String importDataFromXML(String read) {
        StringBuilder sb = new StringBuilder();

        try {
            RaceWrapperXMLImportDto raceDto = this.parser.read(RaceWrapperXMLImportDto.class, read);
            int idCounter = 0;
            for (RaceXMLImportDto r : raceDto.getRaces()) {
                if (ValidationUtil.isValid(r)) {
                    this.raceService.save(r);
                    sb.append(String.format("Successfully imported Race - %d.", ++idCounter))
                            .append(System.lineSeparator());
                } else {
                    sb.append("Error: Duplicate Data!").append(System.lineSeparator());
                }
            }
//            raceDto.getRaces()
//                    .forEach(r -> {
//                        if (ValidationUtil.isValid(r)) {
//                            this.raceService.save(r);
//                            sb.append(String.format("Successfully imported Race - %d.", ++idCounter))
//                                    .append(System.lineSeparator());
//                        } else {
//                            sb.append("Error: Duplicate Data!").append(System.lineSeparator());
//                        }
//                    });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
