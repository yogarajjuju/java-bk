package Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();
        HashSet<String> names = new HashSet<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(101, "Yogaraj");
        map.put(102, "Anya");
        names.add("Yogaraj");
        names.add("Anya");
        names.add("Anya");

        students.add("Yogaraj");
        students.add("Rahul");
        students.add("Arun");
        students.add("juju");
        students.add("Anya");

        System.out.println(students);

        for(String student : students){
            System.out.println(student);
        }
        System.out.println(names);
        System.out.println(map.get(101));
    }
}