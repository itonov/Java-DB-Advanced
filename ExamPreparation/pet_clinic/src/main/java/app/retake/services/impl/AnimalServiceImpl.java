package app.retake.services.impl;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.domain.models.Animal;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalRepository;
import app.retake.repositories.PassportRepository;
import app.retake.services.api.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(dontRollbackOn = Exception.class)
public class AnimalServiceImpl implements AnimalService {

    private final ModelParser parser;
    private final AnimalRepository animalRepository;
    private final PassportRepository passportRepository;

    @Autowired
    public AnimalServiceImpl(ModelParser parser,
                             AnimalRepository animalRepository,
                             PassportRepository passportRepository) {
        this.parser = parser;
        this.animalRepository = animalRepository;
        this.passportRepository = passportRepository;
    }


    @Override
    public void create(AnimalJSONImportDTO dto) {
        Animal animal = this.parser.convert(dto, Animal.class);
        if (this.passportRepository.findOne(dto.getPassport().getSerialNumber()) != null) {
            throw new IllegalArgumentException();
        }
        this.animalRepository.saveAndFlush(animal);
    }

    @Override
    public List<AnimalsJSONExportDTO> findByOwnerPhoneNumber(String phoneNumber) {
        List<Animal> animals = this.animalRepository.findByOwnerPhoneNumber(phoneNumber);

        return animals.stream()
                .map(a -> {
                    AnimalsJSONExportDTO animalDto = new AnimalsJSONExportDTO();
                    animalDto.setAge(a.getAge());
                    animalDto.setAnimalName(a.getName());
                    animalDto.setOwnerName(a.getPassport().getOwnerName());
                    animalDto.setRegisteredOn(a.getPassport().getRegistrationDate());
                    animalDto.setSerialNum(a.getPassport().getSerialNumber());
                    return animalDto;
                }).collect(Collectors.toList());
    }
}
