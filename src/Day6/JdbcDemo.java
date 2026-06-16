package Day6;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {

        String url =
                "jdbc:sqlite:/home/juju/IdeaProjects/java-bk/src/Day5/students.db";

        try (
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        ) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("department")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}