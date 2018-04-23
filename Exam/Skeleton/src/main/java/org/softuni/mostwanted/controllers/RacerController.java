package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.RacerJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.api.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class RacerController {

    private final RacerService racerService;
    private final Parser parser;

    @Autowired
    public RacerController(RacerService racerService,
                           @Qualifier(value = "JSONParser") Parser parser) {
        this.racerService = racerService;
        this.parser = parser;
    }

    public String importDataFromJSON(String read) {
        StringBuilder sb = new StringBuilder();

        try {
            RacerJSONImportDto[] racerDtos = this.parser.read(RacerJSONImportDto[].class, read);
            Arrays.stream(racerDtos)
                    .forEach(r -> {
                        if (ValidationUtil.isValid(r)) {
                            if (this.racerService.findByName(r.getName()) == null) {
                                this.racerService.create(r);
                                sb.append(String.format("Successfully imported Racer - %s.", r.getName()))
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
