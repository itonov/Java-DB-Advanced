package soft_uni.lab_exercises.projection.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft_uni.lab_exercises.projection.entities.Employee;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getAllByBirthdayBeforeOrderBySalaryDesc(Date date);

}
