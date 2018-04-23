package org.softuni.mostwanted.services.api;

import org.softuni.mostwanted.domain.dtos.DistrictJSONImportDto;
import org.softuni.mostwanted.domain.models.District;

public interface DistrictService {

    District findByNameAndTownName(String distName, String townName);

    void create(DistrictJSONImportDto districtDto);

    District findByName(String name);
}
