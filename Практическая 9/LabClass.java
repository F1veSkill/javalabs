package ru.mirea.prac9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LabClass {
    private final List<Student> students;

    public LabClass(){
        this.students = new ArrayList<>();
    }

    public LabClass(List<Student> students){
        this.students = students;
    }

    public LabClass sort() {
        this.students.sort(Comparator.comparingInt(Student::getGrade));
        return this;
    }

    public LabClass add(Student student) {
        this.students.add(student);
        return this;
    }

    public LabClass remove(Student student) {
        this.students.remove(student);
        return this;
    }

    public List<Student> findById (String id){
        List<Student> list = new ArrayList<>();
        for (Student student: students) {
            if(student.getId().equals(id)){
                list.add(student);
                return list;
            }
        }
        throw new StudentNotFoundException();
    }

    public List<Student> findByName(String name){
        List<Student> list = new ArrayList<>();
        for (Student student: students) {
            if(student.getName().equals(name)){
                list.add(student);
            }
        }
        return list;
    }

    public List<Student> getStudents(){
        return students;
    }
}
