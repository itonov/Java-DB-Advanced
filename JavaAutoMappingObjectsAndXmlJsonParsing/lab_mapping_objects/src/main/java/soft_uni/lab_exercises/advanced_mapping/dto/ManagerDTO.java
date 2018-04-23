package soft_uni.lab_exercises.advanced_mapping.dto;

import soft_uni.lab_exercises.advanced_mapping.Employee;

import java.util.ArrayList;
import java.util.List;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private List<Employee> employeesInCharge;

    public ManagerDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeesInCharge = new ArrayList<>();
    }

    public ManagerDTO() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Employee> getEmployeesInCharge() {
        return this.employeesInCharge;
    }

    public void setEmployeesInCharge(List<Employee> employeesInCharge) {
        this.employeesInCharge = employeesInCharge;
    }

    public int getEmployeesCount() {
        return this.employeesInCharge.size();
    }

    public void addEmployee(Employee employee) {
        this.employeesInCharge.add(employee);
    }
}
