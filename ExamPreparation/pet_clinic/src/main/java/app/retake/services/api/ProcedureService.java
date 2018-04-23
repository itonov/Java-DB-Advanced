package app.retake.services.api;

import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;

public interface ProcedureService {
    public void create(ProcedureXMLImportDTO dto);

    ProcedureWrapperXMLExportDTO exportProcedures();
}
