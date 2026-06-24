package Day9;

import Day7.Student;
import Day7.StudentDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVImportService {

    public void importStudents(String fileName) {

        StudentDAO dao = new StudentDAO();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // Skip CSV header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String department = data[3];

                Student student = new Student(
                        name,
                        age,
                        department
                );

//                dao.addStudent(student);
                if (!dao.studentExists(name, age, department)) {
                    dao.addStudent(student);
                } else {
                    System.out.println("Student already exists. Skipping...");
                }
            }

            System.out.println("CSV Import Completed!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}