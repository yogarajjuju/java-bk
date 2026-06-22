package Day8;

import Day7.Student;

import java.io.FileWriter;
import java.util.List;

public class CSVExportService {

    public void exportStudents(List<Student> students) {

        try (FileWriter writer =
                     new FileWriter("students.csv")) {

            writer.write("id,name,age,department\n");

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getDepartment() + "\n"
                );
            }

            System.out.println("CSV Export Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}