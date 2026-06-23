package  Day9;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVImportService {


    public void importStudents(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // Skip Header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String department = data[3];

                Student student = new Student(
                        id,
                        name,
                        age,
                        department
                );

                System.out.println(student);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}