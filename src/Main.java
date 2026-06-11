class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}
    class Student extends Person{
        int marks;
        Student(String name , int marks){
            super(name);
            this.marks = marks;


        }
        void show(){
            System.out.println(name + " " + marks);
        }


    }
class Employee  extends Person{
    int empid;
    int salary;
    Employee(String name , int empid, int salary){
        super(name);
        this.empid= empid;
        this.salary= salary;

    }

    void show(){
        System.out.println(name + empid+ salary);
    }

}


        public class Main {
            public static void main(String[] args) {
                Student s = new Student("Yogaraj", 90);
                s.show();
                Employee e = new Employee("juju", 1, 4000);
                e.show();
            }

    }

