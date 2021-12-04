package ru.mirea.lab4;

public class Pet implements Nameable{
    private final String name;

    public Pet(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
