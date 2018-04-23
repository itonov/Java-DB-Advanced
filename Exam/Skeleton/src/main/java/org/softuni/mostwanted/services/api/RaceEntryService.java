package org.softuni.mostwanted.services.api;

import org.softuni.mostwanted.domain.dtos.RaceEntryXMLImportDto;
import org.softuni.mostwanted.domain.models.RaceEntry;

public interface RaceEntryService {

    Integer save(RaceEntryXMLImportDto raceEntryDto);

    RaceEntry findById(Integer id);
}
