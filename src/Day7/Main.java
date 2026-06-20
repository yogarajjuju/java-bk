package Day7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    Student student =
                            new Student(name, age, department);

                    dao.addStudent(student);

                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    dao.updateStudent(updateId, newAge);

                    break;
                case 4:

                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    dao.deleteStudent(deleteId);

                    break;
                case 5:

                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}