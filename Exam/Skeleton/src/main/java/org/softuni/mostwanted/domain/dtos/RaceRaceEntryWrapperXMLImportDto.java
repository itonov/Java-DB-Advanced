package org.softuni.mostwanted.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceRaceEntryWrapperXMLImportDto {

    @XmlElement(name = "entry")
    private List<RaceRaceEntryXMLImportDto> entries;

    public RaceRaceEntryWrapperXMLImportDto() {
    }

    public List<RaceRaceEntryXMLImportDto> getEntries() {
        return this.entries;
    }

    public void setEntries(List<RaceRaceEntryXMLImportDto> entries) {
        this.entries = entries;
    }
}
