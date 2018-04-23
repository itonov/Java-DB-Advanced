package tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] employeeNames = reader.readLine().split(" ");
        String firstName = employeeNames[0];
        String lastName = employeeNames[1];

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Employee> employees = em.createQuery("FROM Employee ").getResultList();
        boolean foundMatch = false;

        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                System.out.println("Yes");
                foundMatch = true;
                break;
            }
        }

        if (!foundMatch) {
            System.out.println("No");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
