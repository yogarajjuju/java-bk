package Day4;
import java.io.*;
import  java.util.*;


public class Main {
    public static void main(String[] args) {
        try{
            File file = new File("Students.txt");
            Scanner in = new Scanner(file);
            while(in.hasNextLine()) {
                System.out.println(in.nextLine());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
