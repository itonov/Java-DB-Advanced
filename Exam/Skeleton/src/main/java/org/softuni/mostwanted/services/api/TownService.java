package org.softuni.mostwanted.services.api;

import org.softuni.mostwanted.domain.dtos.TownJSONImportDto;
import org.softuni.mostwanted.domain.models.Town;

public interface TownService {

    Town findByName(String townName);

    void create(TownJSONImportDto townDto);
}
