package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeesByFirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameStart = reader.readLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> employees = em.createQuery("FROM Employee e WHERE LOWER(SUBSTRING(e.firstName, 1, 2)) =:nameStart")
                .setParameter("nameStart", nameStart.toLowerCase()).getResultList();

        em.close();
        emf.close();

        for (Employee employee : employees) {
            System.out.printf("%s %s - %s - ($%.2f)%n", employee.getFirstName(), employee.getLastName(),
                    employee.getJobTitle(), employee.getSalary());
        }
    }
}
