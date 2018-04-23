package org.softuni.mostwanted.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceXMLImportDto {

    @XmlElement
    @NotNull
    private Integer laps;
    @XmlElement(name = "district-name")
    private String districtName;
    @XmlElement(name = "entries")
    private RaceRaceEntryWrapperXMLImportDto entries;

    public RaceXMLImportDto() {
    }

    public Integer getLaps() {
        return this.laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public RaceRaceEntryWrapperXMLImportDto getEntries() {
        return this.entries;
    }

    public void setEntries(RaceRaceEntryWrapperXMLImportDto entries) {
        this.entries = entries;
    }
}
