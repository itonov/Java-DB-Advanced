package soft_uni.lab_exercises.advanced_mapping;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import soft_uni.lab_exercises.advanced_mapping.dto.ManagerDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("sasho", "aleksiev", "1950-12-12",
                BigDecimal.valueOf(250.60), true, "struma 12", new Employee());
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);

        List<ManagerDTO> managers = employees.stream().map(e -> modelMapper.map(e, ManagerDTO.class)).collect(Collectors.toList());
        System.out.println();
    }
}
