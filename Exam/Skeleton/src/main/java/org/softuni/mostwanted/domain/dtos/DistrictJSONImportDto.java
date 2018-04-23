package org.softuni.mostwanted.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class DistrictJSONImportDto {

    @Expose
    @NotNull
    private String name;
    @Expose
    private String townName;

    public DistrictJSONImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return this.townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
