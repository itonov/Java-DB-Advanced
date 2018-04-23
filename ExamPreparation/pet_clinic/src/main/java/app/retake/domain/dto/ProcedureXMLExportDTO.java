package app.retake.domain.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "procedure")
public class ProcedureXMLExportDTO {

    @XmlAttribute(name = "animal-passport")
    private String animalPassport;
    @XmlElement(name = "owner")
    private String ownerPhone;
    @XmlElementWrapper(name = "animal-aids")
    @XmlElement(name = "animal-aid")
    private List<ProcedureAnimalAidXMLExportDTO> animalAids;

    public ProcedureXMLExportDTO() {
        this.animalAids = new ArrayList<>();
    }

    public String getAnimalPassport() {
        return this.animalPassport;
    }

    public void setAnimalPassport(String animalPassport) {
        this.animalPassport = animalPassport;
    }

    public String getOwnerPhone() {
        return this.ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public List<ProcedureAnimalAidXMLExportDTO> getAnimalAids() {
        return this.animalAids;
    }

    public void setAnimalAids(List<ProcedureAnimalAidXMLExportDTO> animalAids) {
        this.animalAids = animalAids;
    }
}
