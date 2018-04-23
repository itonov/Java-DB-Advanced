package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.TownJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class TownController {

    private final Parser parser;
    private final TownService townService;

    @Autowired
    public TownController(@Qualifier(value = "JSONParser") Parser parser,
                          TownService townService) {
        this.parser = parser;
        this.townService = townService;
    }

    public String importDataFromJSON(String jsonContext) {
        StringBuilder sb = new StringBuilder();

        try {
            TownJSONImportDto[] townDtos = this.parser.read(TownJSONImportDto[].class, jsonContext);
            Arrays.stream(townDtos)
                    .forEach(t -> {
                        if (ValidationUtil.isValid(t)) {
                            if (this.townService.findByName(t.getName()) == null) {
                                this.townService.create(t);
                                sb.append(String.format("Successfully imported Town - %s.", t.getName()))
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
