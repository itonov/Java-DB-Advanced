package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.TownJSONImportDto;
import org.softuni.mostwanted.domain.models.Town;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelParser modelParser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           ModelParser modelParser) {
        this.townRepository = townRepository;
        this.modelParser = modelParser;
    }

    @Override
    public Town findByName(String townName) {
        return this.townRepository.findByName(townName);
    }

    @Override
    public void create(TownJSONImportDto townDto) {
        Town town = this.modelParser.convert(townDto, Town.class);
        this.townRepository.saveAndFlush(town);
    }
}
