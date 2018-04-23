package org.softuni.mostwanted.services.api;

import org.softuni.mostwanted.domain.dtos.RaceXMLImportDto;

public interface RaceService {
    void save(RaceXMLImportDto raceDto);
}
