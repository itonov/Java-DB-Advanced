package soft_uni.lab_exercises.projection.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.lab_exercises.projection.entities.Employee;
import soft_uni.lab_exercises.projection.repositories.EmployeeRepository;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> employeesBornBefore(Date date) {
        return this.employeeRepository.getAllByBirthdayBeforeOrderBySalaryDesc(date);
    }

    @Override
    public void addEmployeesToDb(List<Employee> employees) {
        this.employeeRepository.saveAll(employees);
    }


}
