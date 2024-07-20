package Java.Assignment_I;

import java.util.ArrayList;

public class Student {
    private String name;
    private int roll;
    private int age;
    private int marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    Student(String name, int roll, int age, int marks) {
        this.name = name;
        this.roll = roll;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return this.name + "--" + this.roll + "--" + this.age + "--" + this.marks;
    }

    public static void main(String[] args) {
        ArrayList<Student> db = new ArrayList<>();

        db.add(new Student("Riya", 56, 23, 89));
        db.add(new Student("Jackson", 24, 28, 78));
        db.add(new Student("Amina", 48, 23, 80));
        db.add(new Student("Soumya", 35, 21, 75));

        db.forEach(Student -> System.out.println(Student));

        /* Sorting on Name: */
        db.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("Based on name: " + db);

        /* Sorting on Roll: */
        db.sort((a, b) -> (a.getRoll() < b.getRoll()) ? -1 : 1);
        System.out.println("Based on roll: " + db);

        /* Sorting on Age: */
        db.sort((a, b) -> (a.getAge() < b.getAge()) ? -1 : 1);
        System.out.println("Based on age: " + db);

        /* Sorting on marks: */
        db.sort((a, b) -> (a.getMarks() < b.getMarks()) ? -1 : 1);
        System.out.println("Based on marks: " + db);
    }
}
