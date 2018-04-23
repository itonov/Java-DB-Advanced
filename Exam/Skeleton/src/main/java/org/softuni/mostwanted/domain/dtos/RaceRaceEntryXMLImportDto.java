package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceRaceEntryXMLImportDto {

    @XmlAttribute(name = "id")
    private String id;

    public RaceRaceEntryXMLImportDto() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
