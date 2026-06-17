package Day6;

import java.sql.*;

public class JdbcDemo {


    static String url =
            "jdbc:sqlite:/home/juju/IdeaProjects/java-bk/src/Day5/students.db";

    // CREATE / INSERT
    public static void addStudent() {
        String sql =
                "INSERT INTO students(name, age, department) VALUES(?,?,?)";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setString(1, "Rahul");
            pstmt.setInt(2, 20);
            pstmt.setString(3, "AI&DS");

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " row inserted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ / SELECT
    public static void viewStudents() {

        String sql = "SELECT * FROM students";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

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

    // UPDATE
    public static void updateStudent() {

        String sql =
                "UPDATE students SET age = ? WHERE name = ?";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setInt(1, 25);
            pstmt.setString(2, "Rahul");

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " row updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteStudent() {

        String sql =
                "DELETE FROM students WHERE name = ?";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {

            pstmt.setString(1, "Rahul");

            int rows = pstmt.executeUpdate();

            System.out.println(rows + " row deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Uncomment one at a time to test

         addStudent();

        viewStudents();

         updateStudent();

         deleteStudent();
    }


}
