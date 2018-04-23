package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class EmployeesWithSalary {
    public static void main(String[] args) {
        int neededSalary = 50000;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> employees = em.createQuery("FROM Employee e WHERE e.salary >:neededSalary")
                .setParameter("neededSalary", BigDecimal.valueOf(neededSalary)).getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }

        em.close();
        emf.close();
    }
}
