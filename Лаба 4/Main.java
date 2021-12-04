package ru.mirea.lab4;

public class Main {

    public static void main(String[] args) {
        Nameable nameable = new Person("Иван", "Лиханов");
        System.out.println(nameable.getName());
        nameable = new Pet("Черепашка");
        System.out.println(nameable.getName());
    }
}
