package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] studentTokens = reader.readLine().split(" ");
        String[] workerTokens = reader.readLine().split(" ");

        try {
            Student student = new Student(studentTokens[0], studentTokens[1], studentTokens[2]);
            Worker worker = new Worker(workerTokens[0], workerTokens[1], Double.parseDouble(workerTokens[2]),
                    Double.parseDouble(workerTokens[3]));

            System.out.printf("First Name: %s%nLast Name: %s%nFaculty number: %s%n%n", student.getFirstName(),
                    student.getLastName(), student.getFacultyNumber());
            System.out.printf("First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                    worker.getFirstName(), worker.getLastName(), worker.getSalary(), worker.getWorkingHours(),
                    worker.calculateSalaryPerHour());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
