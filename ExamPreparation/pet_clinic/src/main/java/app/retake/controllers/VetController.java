package app.retake.controllers;

import app.retake.domain.dto.VetWrapperXMLImportDTO;
import app.retake.parser.ValidationUtil;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
public class VetController {

    private final Parser parser;
    private final VetService vetService;

    public VetController(@Qualifier(value = "XMLParser") Parser parser,
                         VetService vetService) {
        this.parser = parser;
        this.vetService = vetService;
    }

    public String importDataFromXML(String xmlContent) {
        StringBuilder sb = new StringBuilder();

        try {
            VetWrapperXMLImportDTO vetWrapperXMLImportDTO = this.parser.read(VetWrapperXMLImportDTO.class, xmlContent);
            vetWrapperXMLImportDTO.getVets()
                    .forEach(v -> {
                        if (ValidationUtil.isValid(v)) {
                            this.vetService.create(v);
                            sb.append(String.format("Record %s successfully imported.", v.getName()))
                                    .append(System.lineSeparator());
                        } else {
                            sb.append("Error: Invalid data.").append(System.lineSeparator());
                        }
                    });
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
