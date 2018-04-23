package app.retake;

import app.retake.controllers.AnimalAidController;
import app.retake.controllers.AnimalController;
import app.retake.controllers.ProcedureController;
import app.retake.controllers.VetController;
import app.retake.io.api.ConsoleIO;
import app.retake.io.api.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    private final AnimalAidController animalAidController;
    private final AnimalController animalController;
    private final VetController vetController;
    private final ProcedureController procedureController;
    private final FileIO fileIO;
    private final ConsoleIO consoleIO;

    @Autowired
    public Terminal(AnimalAidController animalAidController,
                    AnimalController animalController,
                    VetController vetController,
                    ProcedureController procedureController,
                    FileIO fileIO,
                    ConsoleIO consoleIO) {
        this.animalAidController = animalAidController;
        this.animalController = animalController;
        this.vetController = vetController;
        this.procedureController = procedureController;
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
    }


    @Override
    public void run(String... strings) throws Exception {
//        seedAnimalAidsFromJson();
//        seedAnimalsFromJson();
//        seedVetsFromXml();
//        seedProceduresFromXml();
//        exportAnimalsToJson();
        exportProceduresToXml();
    }

    private void exportProceduresToXml() throws IOException, JAXBException {
        this.fileIO.write(this.procedureController.exportProcedures(), "proceduresExport.xml");
    }

    private void exportAnimalsToJson() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phoneNumber = reader.readLine();
        this.fileIO.write(this.animalController.exportAnimalsByOwnerPhoneNumber(phoneNumber), "animalsExport.json");
    }

    private void seedProceduresFromXml() throws IOException {
        this.consoleIO.write(this.procedureController.importDataFromXML(this.fileIO.read(Config.PROCEDURES_IMPORT_XML)));
    }

    private void seedVetsFromXml() throws IOException {
        this.consoleIO.write(this.vetController.importDataFromXML(this.fileIO.read(Config.VETS_IMPORT_XML)));
    }

    private void seedAnimalsFromJson() throws IOException {
        this.consoleIO.write(this.animalController.importDataFromJSON(this.fileIO.read(Config.ANIMALS_IMPORT_JSON)));
    }

    private void seedAnimalAidsFromJson() throws IOException {
        this.consoleIO.write(this.animalAidController.importDataFromJSON(this.fileIO.read(Config.ANIMAL_AIDS_IMPORT_JSON)));
    }
}
