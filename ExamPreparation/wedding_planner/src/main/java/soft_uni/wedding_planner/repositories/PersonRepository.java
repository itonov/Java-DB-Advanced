package soft_uni.wedding_planner.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import soft_uni.wedding_planner.models.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByFirstNameAndMiddleNameInitialAndLastName(String firstName, String middleInitial, String lastName);
}