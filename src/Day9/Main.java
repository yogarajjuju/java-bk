package Day9;
public class Main {


    public static void main(String[] args) {

        CSVImportService importer = new CSVImportService();

        importer.importStudents("students.csv");
    }
}