package Day9;

import Day7.StudentDAO;

public class Main {

    public static void main(String[] args) {

        CSVImportService importer = new CSVImportService();

        importer.importStudents("students.csv");

        System.out.println("\nImported Students:");

        StudentDAO dao = new StudentDAO();

        dao.viewStudents();

    }
}