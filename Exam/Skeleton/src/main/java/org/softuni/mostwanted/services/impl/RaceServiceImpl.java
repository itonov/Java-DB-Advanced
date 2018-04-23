package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.RaceRaceEntryXMLImportDto;
import org.softuni.mostwanted.domain.dtos.RaceXMLImportDto;
import org.softuni.mostwanted.domain.models.Race;
import org.softuni.mostwanted.repositories.RaceRepository;
import org.softuni.mostwanted.services.api.DistrictService;
import org.softuni.mostwanted.services.api.RaceEntryService;
import org.softuni.mostwanted.services.api.RaceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final DistrictService districtService;
    private final RaceEntryService raceEntryService;

    public RaceServiceImpl(RaceRepository raceRepository,
                           DistrictService districtService,
                           RaceEntryService raceEntryService) {
        this.raceRepository = raceRepository;
        this.districtService = districtService;
        this.raceEntryService = raceEntryService;
    }


    @Override
    public void save(RaceXMLImportDto raceDto) {
        Race race = new Race();
        race.setDistrict(this.districtService.findByName(raceDto.getDistrictName()));
        race.setLaps(raceDto.getLaps());
        for (RaceRaceEntryXMLImportDto re : raceDto.getEntries().getEntries()) {
            race.getEntries().add(this.raceEntryService.findById(Integer.parseInt(re.getId())));
        }
//        race.setEntries(raceDto.getEntries().getEntries().stream().map(e -> this.raceEntryService.findById(Integer.parseInt(e.getId()))).collect(Collectors.toSet()));
        this.raceRepository.saveAndFlush(race);
    }
}
