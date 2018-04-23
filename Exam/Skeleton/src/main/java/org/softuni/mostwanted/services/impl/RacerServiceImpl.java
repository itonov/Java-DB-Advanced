package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.RacerJSONImportDto;
import org.softuni.mostwanted.domain.models.Racer;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.services.api.RacerService;
import org.softuni.mostwanted.services.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RacerServiceImpl implements RacerService {

    private final RacerRepository racerRepository;
    private final TownService townService;

    @Autowired
    public RacerServiceImpl(RacerRepository racerRepository,
                            TownService townService) {
        this.racerRepository = racerRepository;
        this.townService = townService;
    }

    @Override
    public Racer findByName(String name) {
        return this.racerRepository.findByName(name);
    }

    @Override
    public void create(RacerJSONImportDto racerDto) {
        Racer racer = new Racer();
        racer.setAge(racerDto.getAge());
        racer.setBounty(racerDto.getBounty());
        racer.setName(racerDto.getName());
        racer.setHomeTown(this.townService.findByName(racerDto.getHomeTown()));
        this.racerRepository.saveAndFlush(racer);
    }
}
