package soft_uni.wedding_planner.services.person;

import soft_uni.wedding_planner.models.entities.Person;

import java.util.List;

public interface PersonService {

    void saveAllToDb(List<Person> people);

    Person getByFullName(String fullName);
}