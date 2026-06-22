package Day7;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class StudentDAO {

    private final String url =
            "jdbc:sqlite:/home/juju/IdeaProjects/java-bk/src/Day5/students.db";

    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            System.out.println("\n===== STUDENTS =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addStudent(Student student) {

        String sql =
                "INSERT INTO students(name, age, department) VALUES(?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getDepartment());

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " student added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, int newAge) {

        String sql =
                "UPDATE students SET age = ? WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " student updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) {

        String sql =
                "DELETE FROM students WHERE id = ?";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " student deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {

                Student student =
                        new Student(
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getString("department")
                        );

                student.setId(rs.getInt("id"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}