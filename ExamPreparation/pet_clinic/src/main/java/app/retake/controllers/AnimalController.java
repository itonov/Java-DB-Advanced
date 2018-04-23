package app.retake.controllers;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class AnimalController {

    private final Parser parser;
    private final AnimalService animalService;

    @Autowired
    public AnimalController(@Qualifier(value = "JSONParser") Parser parser,
                            AnimalService animalService) {
        this.parser = parser;
        this.animalService = animalService;
    }

    public String importDataFromJSON(String jsonContent) {
        StringBuilder sb = new StringBuilder();

        try {
            AnimalJSONImportDTO[] animalJSONImportDTOS = this.parser.read(AnimalJSONImportDTO[].class, jsonContent);
            Arrays.stream(animalJSONImportDTOS)
                    .forEach(a -> {
                        if (ValidationUtil.isValid(a)) {
                            boolean isValid = true;
                            try {
                                this.animalService.create(a);
                            } catch (IllegalArgumentException iae) {
                                isValid = false;
                            }
                            if (isValid) {
                                sb.append(String.format("Record %s Passport №: %s successfully imported.",
                                        a.getName(), a.getPassport().getSerialNumber()))
                                        .append(System.lineSeparator());
                            } else {
                                sb.append("Error: Invalid data.").append(System.lineSeparator());
                            }
                        } else {
                            sb.append("Error: Invalid data.").append(System.lineSeparator());
                        }
                    });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String exportAnimalsByOwnerPhoneNumber(String phoneNumber) {
        List<AnimalsJSONExportDTO> animalsJSONExportDTOS = this.animalService.findByOwnerPhoneNumber(phoneNumber);
        try {
            return this.parser.write(animalsJSONExportDTOS);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
