package Day8;

import Day7.StudentDAO;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        CSVExportService exportService =
                new CSVExportService();

        exportService.exportStudents(
                dao.getAllStudents()
        );
    }
}