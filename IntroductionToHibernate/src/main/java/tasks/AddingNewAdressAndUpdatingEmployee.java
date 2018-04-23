package tasks;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingNewAdressAndUpdatingEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String employeeLastName = reader.readLine();

        Address address = new Address();
        address.setText("Vitoshka 15");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(address);

        Employee employee = em.createQuery("FROM Employee e WHERE e.lastName =:neededLastName", Employee.class)
                .setParameter("neededLastName", employeeLastName).getSingleResult();
        employee.setAddress(address);
        em.persist(employee);
        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
