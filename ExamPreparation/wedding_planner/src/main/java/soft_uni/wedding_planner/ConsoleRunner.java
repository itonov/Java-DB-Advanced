package soft_uni.wedding_planner;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_uni.wedding_planner.models.dtos.binding.invitation.InvitationImportDto;
import soft_uni.wedding_planner.models.dtos.binding.person.PersonImportDto;
import soft_uni.wedding_planner.models.dtos.binding.wedding.WeddingImportDto;
import soft_uni.wedding_planner.models.entities.Agency;
import soft_uni.wedding_planner.models.entities.Invitation;
import soft_uni.wedding_planner.models.entities.Person;
import soft_uni.wedding_planner.models.entities.Wedding;
import soft_uni.wedding_planner.serializers.JsonSerializer;
import soft_uni.wedding_planner.services.agency.AgencyService;
import soft_uni.wedding_planner.services.invitation.InvitationService;
import soft_uni.wedding_planner.services.person.PersonService;
import soft_uni.wedding_planner.services.wedding.WeddingService;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner {

    private final JsonSerializer jsonSerializer;
    private final AgencyService agencyService;
    private final PersonService personService;
    private final InvitationService invitationService;
    private final WeddingService weddingService;
    private final ModelMapper modelMapper;

    @Autowired
    public ConsoleRunner(JsonSerializer jsonSerializer,
                         AgencyService agencyService,
                         PersonService personService,
                         InvitationService invitationService,
                         WeddingService weddingService) {
        this.jsonSerializer = jsonSerializer;
        this.agencyService = agencyService;
        this.personService = personService;
        this.invitationService = invitationService;
        this.weddingService = weddingService;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public void run(String... args) throws Exception {
//        importAgenciesFromJsonToDb();
//        importPeopleFromJsonToDb();
        importWeddingsFromJsonToDb();
    }

    private void importWeddingsFromJsonToDb() throws FileNotFoundException {
        WeddingImportDto[] weddingImportDtos = this.jsonSerializer.importFromFile(WeddingImportDto[].class, "weddings.json");
        for (WeddingImportDto wedding : weddingImportDtos) {
            if (wedding.getBrideName() == null || wedding.getBridegroomName() == null || wedding.getAgency() == null
                    || wedding.getDate() == null) {
                System.out.println("Error. Invalid data provided.");
            } else {
                List<InvitationImportDto> invitationImportDtos = wedding.getInvitations();
                PropertyMap<WeddingImportDto, Wedding> propertyMap = new PropertyMap<WeddingImportDto, Wedding>() {
                    @Override
                    protected void configure() {
                        destination.setBride(personService.getByFullName(source.getBrideName()));
                        destination.setBrideGroom(personService.getByFullName(source.getBridegroomName()));
                        destination.setDate(source.getDate());
                        destination.setInvitations(source.getInvitations()
                                .stream()
                                .map(i -> {
                                    Invitation invitation = new Invitation();
                                    invitation.setFamily(i.getFamily());
                                    invitation.setGuest(personService.getByFullName(i.getName()));
                                    invitation.setAttending(i.getRsvp());
                                    invitation.setWedding(destination);
                                    return invitation;
                                }).collect(Collectors.toSet()));
                    }
                };

                Wedding wedding1 = this.modelMapper.addMappings(propertyMap).map(wedding);
                System.out.println();
                }
            }
        }


    private void importPeopleFromJsonToDb() throws FileNotFoundException {
        PersonImportDto[] personImportDtos = this.jsonSerializer.importFromFile(PersonImportDto[].class, "people.json");
        List<Person> people = new ArrayList<>();

        for (PersonImportDto personDto : personImportDtos) {
            Person person = new Person();
            try {
                person.setFirstName(personDto.getFirstName());
                person.setLastName(personDto.getLastName());
                person.setEmail(personDto.getEmail());
                person.setGender(personDto.getGender());
                person.setPhone(personDto.getPhone());
                person.setBirthDate(personDto.getBirthDate());
                person.setMiddleNameInitial(personDto.getMiddleNameInitial());
                people.add(person);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        this.personService.saveAllToDb(people);
    }

    private void importAgenciesFromJsonToDb() throws FileNotFoundException {
        Agency[] agencies = this.jsonSerializer.importFromFile(Agency[].class, "agencies.json");
        this.agencyService.saveAllToDb(Arrays.asList(agencies));
    }
}
