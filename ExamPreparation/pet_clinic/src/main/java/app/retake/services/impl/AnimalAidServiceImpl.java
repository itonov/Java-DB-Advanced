package app.retake.services.impl;


import app.retake.domain.dto.AnimalAidJSONImportDTO;
import app.retake.domain.models.AnimalAid;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalAidRepository;
import app.retake.services.api.AnimalAidService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AnimalAidServiceImpl implements AnimalAidService {

    private final AnimalAidRepository animalAidRepository;
    private final ModelParser modelParser;

    public AnimalAidServiceImpl(AnimalAidRepository animalRepository,
                                ModelParser modelParser) {
        this.animalAidRepository = animalRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void create(AnimalAidJSONImportDTO dto) {
        AnimalAid animalAid = this.animalAidRepository.findByName(dto.getName());

        if (animalAid != null) {
            animalAid.setPrice(dto.getPrice());
        } else {
            animalAid = this.modelParser.convert(dto, AnimalAid.class);
        }
        this.animalAidRepository.saveAndFlush(animalAid);
    }
}
