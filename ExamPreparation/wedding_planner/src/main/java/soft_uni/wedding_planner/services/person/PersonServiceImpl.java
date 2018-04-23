package soft_uni.wedding_planner.services.person;

import soft_uni.wedding_planner.models.entities.Person;
import soft_uni.wedding_planner.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) { 
		this.personRepository = personRepository;
	}

	@Override
	public void saveAllToDb(List<Person> people) {
		this.personRepository.saveAll(people);
	}

	@Override
	public Person getByFullName(String fullName) {
		String[] nameTokens = fullName.split(" ");
		Person person = this.personRepository.findByFirstNameAndMiddleNameInitialAndLastName(nameTokens[0], nameTokens[1], nameTokens[2]);
		System.out.println();
		return this.personRepository.findByFirstNameAndMiddleNameInitialAndLastName(nameTokens[0], nameTokens[1], nameTokens[2]);
	}
}