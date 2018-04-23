package soft_uni.lab_exercises.projection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import soft_uni.lab_exercises.projection.dto.EmployeeDTO;
import soft_uni.lab_exercises.projection.entities.Employee;
import soft_uni.lab_exercises.projection.services.EmployeeService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ConsoleRunner implements CommandLineRunner {
    private final EmployeeService employeeService;

    @Autowired
    public ConsoleRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employees = new ArrayList<>();
        Calendar calendarAfter2000 = Calendar.getInstance();
        calendarAfter2000.set(Calendar.YEAR, 2001);
        Date after = calendarAfter2000.getTime();

        Calendar calendarBefore2000 = Calendar.getInstance();
        calendarBefore2000.set(Calendar.YEAR, 1995);
        Date before = calendarBefore2000.getTime();

        Employee employeeBefore = new Employee("gosho", "petrov", BigDecimal.valueOf(250.80), before, "vardar 20");
        Employee employeeAfter = new Employee("gosho", "petrov", BigDecimal.valueOf(250.80), after, "vardar 20");

        employeeBefore.setManager(employeeAfter);

        employees.add(employeeBefore);

        employees.add(employeeAfter);

        this.employeeService.addEmployeesToDb(employees);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        List<Employee> toTransform = this.employeeService.employeesBornBefore(calendar.getTime());

        ModelMapper modelMapper = new ModelMapper();
        List<EmployeeDTO> employeeDTOS = toTransform.stream()
                .map(e -> modelMapper.map(e, EmployeeDTO.class))
                .collect(Collectors.toList());

        for (EmployeeDTO employee : employeeDTOS) {
            System.out.println(employee.getManagerLastName());
        }
    }
}
