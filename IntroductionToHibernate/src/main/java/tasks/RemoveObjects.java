package tasks;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RemoveObjects {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        List<Town> towns = em.createQuery("FROM Town").getResultList();
        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.persist(town);
                em.remove(town);
                em.flush();
            } else {
                town.setName(town.getName().toLowerCase());
                em.merge(town);
            }
        }
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
