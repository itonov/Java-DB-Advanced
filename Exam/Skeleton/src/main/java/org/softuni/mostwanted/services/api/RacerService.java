package org.softuni.mostwanted.services.api;

import org.softuni.mostwanted.domain.dtos.RacerJSONImportDto;
import org.softuni.mostwanted.domain.models.Racer;

public interface RacerService {

    Racer findByName(String name);

    void create(RacerJSONImportDto racerDto);
}
