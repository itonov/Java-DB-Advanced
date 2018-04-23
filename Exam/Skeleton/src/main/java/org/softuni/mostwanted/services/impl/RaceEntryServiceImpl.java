package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.RaceEntryXMLImportDto;
import org.softuni.mostwanted.domain.models.RaceEntry;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.services.api.CarService;
import org.softuni.mostwanted.services.api.RaceEntryService;
import org.softuni.mostwanted.services.api.RacerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RaceEntryServiceImpl implements RaceEntryService {

    private final RaceEntryRepository raceEntryRepository;
    private final RacerService racerService;
    private final CarService carService;

    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository,
                                RacerService racerService,
                                CarService carService) {
        this.raceEntryRepository = raceEntryRepository;
        this.racerService = racerService;
        this.carService = carService;
    }

    @Override
    public Integer save(RaceEntryXMLImportDto raceEntryDto) {
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.setRacer(this.racerService.findByName(raceEntryDto.getRacer()));
        raceEntry.setHasFinished(raceEntryDto.getHasFinished());
        raceEntry.setFinishTime(raceEntryDto.getFinishTime());
        raceEntry.setCar(this.carService.findById(raceEntryDto.getCarId()));
        this.raceEntryRepository.saveAndFlush(raceEntry);
        return this.raceEntryRepository.findRaceEntry(raceEntry).getId();
    }

    @Override
    public RaceEntry findById(Integer id) {
        return this.raceEntryRepository.findOne(id);
    }
}
