package ru.mirea.prac6;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", age = " + age;
    }

    @Override
    public int compareTo(Student o) {
        final int compareName = this.name.compareTo(o.name);
        return compareName != 0 ? compareName : Integer.compare(this.age, o.age);
    }
}
