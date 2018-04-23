package tasks;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetEmployeeWithProject {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int neededId = Integer.parseInt(reader.readLine());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        Employee employee = em.createQuery("FROM Employee e WHERE e.id =:neededId", Employee.class)
                .setParameter("neededId", neededId).getSingleResult();

        Set<Project> projects = employee.getProjects();
        List<Project> orderedProjects = projects.stream().sorted(Comparator.comparing(Project::getName)).collect(Collectors.toList());
        System.out.println(employee.getFirstName() + employee.getLastName() + " - " + employee.getJobTitle());

        for (Project project : orderedProjects) {
            System.out.println(project.getName());
        }

        em.close();
        emf.close();
    }
}
