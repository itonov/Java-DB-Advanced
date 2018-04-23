package app.retake.services.impl;

import app.retake.domain.dto.ProcedureAnimalAidXMLExportDTO;
import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;
import app.retake.domain.models.*;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalAidRepository;
import app.retake.repositories.AnimalRepository;
import app.retake.repositories.ProcedureRepository;
import app.retake.repositories.VetRepository;
import app.retake.services.api.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(dontRollbackOn = Exception.class)
public class ProcedureServiceImpl implements ProcedureService {

    private final ModelParser modelParser;
    private final ProcedureRepository procedureRepository;
    private final VetRepository vetRepository;
    private final AnimalRepository animalRepository;
    private final AnimalAidRepository animalAidRepository;

    @Autowired
    public ProcedureServiceImpl(ModelParser modelParser,
                                ProcedureRepository procedureRepository,
                                VetRepository vetRepository,
                                AnimalRepository animalRepository,
                                AnimalAidRepository animalAidRepository) {
        this.modelParser = modelParser;
        this.procedureRepository = procedureRepository;
        this.vetRepository = vetRepository;
        this.animalRepository = animalRepository;
        this.animalAidRepository = animalAidRepository;
    }

    @Override
    public void create(ProcedureXMLImportDTO dto) {
        Animal animal = this.animalRepository.findByPassportSerialNumber(dto.getAnimalNumber());
        Vet vet = this.vetRepository.findByName(dto.getVetName());

        if (animal == null || vet == null) {
            throw new IllegalArgumentException();
        } else {
            Set<AnimalAid> animalAids = dto.getAnimalAids()
                    .stream()
                    .map(a -> {
                        AnimalAid aid = this.animalAidRepository.findByName(a.getName());
                        if (aid == null) {
                            throw new IllegalArgumentException();
                        } else {
                            return aid;
                        }
                    }).collect(Collectors.toSet());

            Procedure procedure = new Procedure();
            procedure.setAnimal(animal);
            procedure.setVet(vet);
            procedure.setServices(animalAids);
            procedure.setDate(dto.getDate());
            this.procedureRepository.saveAndFlush(procedure);
        }
    }

    @Override
    public ProcedureWrapperXMLExportDTO exportProcedures() {
        List<Procedure> procedures = this.procedureRepository.findAll();
        List<ProcedureXMLExportDTO> dtos = procedures.stream()
                .map(p -> {
                    Passport passport = p.getAnimal().getPassport();

                    List<ProcedureAnimalAidXMLExportDTO> procedureAnimalAidXMLExportDTOS = p.getServices()
                            .stream()
                            .map(ai -> {
                                ProcedureAnimalAidXMLExportDTO aiDto = new ProcedureAnimalAidXMLExportDTO();
                                aiDto.setName(ai.getName());
                                aiDto.setPrice(ai.getPrice());
                                return aiDto;
                            }).collect(Collectors.toList());

                    ProcedureXMLExportDTO exportDTO = new ProcedureXMLExportDTO();

                    exportDTO.setAnimalAids(procedureAnimalAidXMLExportDTOS);
                    exportDTO.setAnimalPassport(passport.getSerialNumber());
                    exportDTO.setOwnerPhone(passport.getOwnerPhoneNumber());
                    return exportDTO;
                }).collect(Collectors.toList());

        ProcedureWrapperXMLExportDTO result = new ProcedureWrapperXMLExportDTO();
        result.setProcedures(dtos);
        return result;
    }
}

