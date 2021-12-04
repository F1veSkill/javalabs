package ru.mirea.lab1;


public class BookTest {
    public static void main(String[] args) {
        Book b1= new Book("First", "Book", 4747, "Future", false);
        Book b2= new Book("Book", "Joni", 2015, "Roman");
        b2.setFinish(true);
        System.out.println(b2.getAuthor());
        System.out.println(b1);
    }
}