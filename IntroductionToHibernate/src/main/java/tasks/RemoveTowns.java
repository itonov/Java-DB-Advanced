package tasks;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townToRemove = reader.readLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Town neededTown = em.createQuery("FROM Town t WHERE t.name =:townName", Town.class)
                .setParameter("townName", townToRemove).getSingleResult();
        List<Address> addresses = em.createQuery("FROM Address a WHERE a.town =:neededTown")
                .setParameter("neededTown", neededTown).getResultList();

        em.persist(neededTown);
        em.remove(neededTown);

        for (Address address : addresses) {
            em.persist(address);
            em.remove(address);
        }

        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();

        if (addresses.size() == 1) {
            System.out.printf("%d address in %s deleted%n", addresses.size(), neededTown.getName());
        } else {
            System.out.printf("%d addresses in %s deleted%n", addresses.size(), neededTown.getName());
        }
    }
}
