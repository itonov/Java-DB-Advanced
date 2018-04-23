package org.softuni.mostwanted.services.impl;

import org.softuni.mostwanted.domain.dtos.DistrictJSONImportDto;
import org.softuni.mostwanted.domain.models.District;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.services.api.DistrictService;
import org.softuni.mostwanted.services.api.TownService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final TownService townService;
    private final ModelParser modelParser;

    public DistrictServiceImpl(DistrictRepository districtRepository,
                               TownService townService,
                               ModelParser modelParser) {
        this.districtRepository = districtRepository;
        this.townService = townService;
        this.modelParser = modelParser;
    }

    @Override
    public District findByNameAndTownName(String distName, String townName) {
        return this.districtRepository.findByNameAndTownName(distName, townName);
    }

    @Override
    public void create(DistrictJSONImportDto districtDto) {
        District district = new District();
        district.setName(districtDto.getName());
        district.setTown(this.townService.findByName(districtDto.getTownName()));
        this.districtRepository.saveAndFlush(district);
    }

    @Override
    public District findByName(String name) {
        return this.districtRepository.findByName(name);
    }


}
