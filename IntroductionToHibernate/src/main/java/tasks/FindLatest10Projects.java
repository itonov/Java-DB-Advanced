package tasks;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Project> projects = em.createQuery("FROM Project p ORDER BY p.startDate DESC ")
                .setMaxResults(10).getResultList();

        projects = projects.stream().sorted(Comparator.comparing(Project::getName)).collect(Collectors.toList());
        for (Project project : projects) {
            System.out.printf("Project name: %s%n" +
                    "\tProject Description: %s%n" +
                    "\tProject Start Date: %s%n" +
                    "\tProject End Date: %s%n", project.getName(), project.getDescription(), project.getStartDate(),
                    project.getEndDate());
        }

        em.close();
        emf.close();
    }
}
