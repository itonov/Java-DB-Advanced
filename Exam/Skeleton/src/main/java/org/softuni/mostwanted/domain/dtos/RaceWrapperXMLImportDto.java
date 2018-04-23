package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceWrapperXMLImportDto {

    @XmlElement(name = "race")
    private List<RaceXMLImportDto> races;

    public RaceWrapperXMLImportDto() {
        this.races = new ArrayList<>();
    }

    public List<RaceXMLImportDto> getRaces() {
        return this.races;
    }

    public void setRaces(List<RaceXMLImportDto> races) {
        this.races = races;
    }
}
