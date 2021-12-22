package ru.mirea.prac9;

import java.util.UUID;

public class Student implements Comparable<Student> {

    private final String id;

    private final String name;
    private final String surname;
    private final String patronymic;

    private int grade;

    public Student(String id, String name, String surname, String patronymic, int grade) {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(grade, o.grade);
    }

    @Override
    public String toString() {
        return "Student" +
                "id=" + id +
                ", name=" + name  +
                ", surname=" + surname +
                ", patronymic=" + patronymic +
                ", grade=" + grade + "\n";
    }
}
