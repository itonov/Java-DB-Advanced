package org.softuni.mostwanted.controllers;

import org.softuni.mostwanted.domain.dtos.DistrictJSONImportDto;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.softuni.mostwanted.services.api.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class DistrictController {

    private final Parser parser;
    private final DistrictService districtService;

    @Autowired
    public DistrictController(@Qualifier(value = "JSONParser") Parser parser,
                              DistrictService districtService) {
        this.parser = parser;
        this.districtService = districtService;
    }

    public String importDataFromJSON(String jsonContext) {
        StringBuilder sb = new StringBuilder();

        try {
            DistrictJSONImportDto[] districtDtos = this.parser.read(DistrictJSONImportDto[].class, jsonContext);
            Arrays.stream(districtDtos)
                    .forEach(d -> {
                        if (ValidationUtil.isValid(d)) {
                            if (this.districtService.findByNameAndTownName(d.getName(), d.getTownName()) == null) {
                                this.districtService.create(d);
                                sb.append(String.format("Successfully imported District - %s.", d.getName()))
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
