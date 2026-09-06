package OopConcept;

class Employee {

    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
    }
}

public class ClassandObject {

    public static void main(String[] args) {
        Employee emp1 = new Employee("Mahima", 101);
        Employee emp2 = new Employee("Rohit", 102);
        emp1.display();
    }
}