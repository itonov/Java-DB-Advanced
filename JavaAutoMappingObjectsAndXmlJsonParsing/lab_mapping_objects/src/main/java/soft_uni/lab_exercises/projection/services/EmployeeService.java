package soft_uni.lab_exercises.projection.services;

import org.springframework.stereotype.Service;
import soft_uni.lab_exercises.projection.entities.Employee;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public interface EmployeeService {
    List<Employee> employeesBornBefore(Date date);

    void addEmployeesToDb(List<Employee> employees);
}
