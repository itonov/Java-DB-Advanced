package soft_uni.lab_exercises.simple_mapping;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee("gosho", "jelev", BigDecimal.valueOf(250.20), "1995-12-12", "botev 4");
        ModelMapper modelMapper = new ModelMapper();
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        System.out.println(employeeDTO.getFirstName());
        System.out.println(employeeDTO.getLastName());
    }
}
