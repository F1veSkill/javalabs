package ru.mirea.lab4;

public class Person implements Nameable {

    private final String name;
    private final String surname;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String getName() {
        return new StringBuilder(name).append(" ").append(surname).toString();
    }
}
