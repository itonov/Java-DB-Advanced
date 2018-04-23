package app.retake.domain.dto;

import app.retake.parser.XMLParser;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "procedure")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureXMLImportDTO {

    @XmlElement(name = "vet")
    private String vetName;
    @XmlElement(name = "animal")
    private String animalNumber;
    @XmlElementWrapper(name = "animal-aids")
    @XmlElement(name = "animal-aid")
    private List<ProcedureAnimalAidXMLImportDTO> animalAids;
    @XmlElement
    @XmlJavaTypeAdapter(XMLParser.DateTimeAdapter.class)
    private Date date;

    public ProcedureXMLImportDTO() {
        this.animalAids = new ArrayList<>();
    }

    public String getVetName() {
        return this.vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getAnimalNumber() {
        return this.animalNumber;
    }

    public void setAnimalNumber(String animalNumber) {
        this.animalNumber = animalNumber;
    }

    public List<ProcedureAnimalAidXMLImportDTO> getAnimalAids() {
        return this.animalAids;
    }

    public void setAnimalAids(List<ProcedureAnimalAidXMLImportDTO> animalAids) {
        this.animalAids = animalAids;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

