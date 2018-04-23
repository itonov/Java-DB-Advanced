package tasks;

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeesMaxSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Department> departments = em.createQuery("FROM Department d").getResultList();
        List<BigDecimal> salaries = new ArrayList<>();

        for (Department department : departments) {
            salaries.add(em.createQuery("FROM Employee e WHERE e.department =:currentDepartment ORDER BY e.salary DESC ",
                    Employee.class).setParameter("currentDepartment", department)
                    .setMaxResults(1).getSingleResult().getSalary());
        }

        em.close();
        emf.close();

        for (int i = 0; i < departments.size(); i++) {
            if (salaries.get(i).compareTo(new BigDecimal(30000.00)) < 0
                    || salaries.get(i).compareTo(new BigDecimal(70000.00)) > 0) {
                System.out.printf("%s - %.2f%n", departments.get(i).getName(), salaries.get(i));
            }
        }

    }
}
