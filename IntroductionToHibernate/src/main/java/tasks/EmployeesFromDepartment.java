package tasks;

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        Department neededDepartment = em.createQuery("FROM Department d WHERE d.name =:depName", Department.class)
                .setParameter("depName", "Research and Development").getSingleResult();
        List<Employee> employees = em.createQuery("FROM Employee e WHERE e.department =:department ORDER BY e.salary ASC, e.id ASC ")
                .setParameter("department", neededDepartment).getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from %s - %.2f%n", employee.getFirstName(), employee.getLastName(),
                    employee.getDepartment().getName(), employee.getSalary());
        }

        em.close();
        emf.close();
    }
}
