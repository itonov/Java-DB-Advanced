package app.retake.services.api;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;

import java.util.List;

public interface AnimalService {
    void create(AnimalJSONImportDTO dto);

    List<AnimalsJSONExportDTO> findByOwnerPhoneNumber(String phoneNumber);
}
