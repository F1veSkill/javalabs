package ru.mirea.prac1;

public class BookTest {

    public static void main(String[] args) {
        Book first = new Book("Первая книга", 500);
        first.printAmountOfBlocks();

        Book second = new Book();
        System.out.println(second.toString());
        second.setPages(700);
        second.printAmountOfBlocks();
    }
}
