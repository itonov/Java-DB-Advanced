package tasks;

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        double increase = 0.12;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Department> departments = em.createQuery("FROM Department d WHERE d.name =:depName")
                .setParameter("depName", "Engineering").getResultList();

        departments.add(em.createQuery("FROM Department d WHERE d.name =:depName", Department.class)
                .setParameter("depName", "Tool Design").getSingleResult());
        departments.add(em.createQuery("FROM Department d WHERE d.name =:depName", Department.class)
                .setParameter("depName", "Marketing").getSingleResult());
        departments.add(em.createQuery("FROM Department d WHERE d.name =:depName", Department.class)
                .setParameter("depName", "Information Services").getSingleResult());

        List<Employee> employees = new ArrayList<>();

        for (Department dep : departments) {
            employees.addAll(em.createQuery("FROM Employee e WHERE e.department =:neededDep")
            .setParameter("neededDep", dep).getResultList());
        }

        em.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary().add(employee.getSalary().multiply(BigDecimal.valueOf(increase))));
            em.persist(employee);
            System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }

        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
