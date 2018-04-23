package app.retake.repositories;

import app.retake.domain.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    Animal findByPassportSerialNumber(String number);

    @Query(value = "SELECT a FROM Animal AS a WHERE a.passport.ownerPhoneNumber = :number " +
            " ORDER BY a.age ASC, a.passport.serialNumber ASC ")
    List<Animal> findByOwnerPhoneNumber(@Param("number") String phoneNumber);
}
