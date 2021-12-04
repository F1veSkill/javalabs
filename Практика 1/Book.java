package ru.mirea.prac1;

public class Book {
    private String name;
    private int pages;
    public Book(String name, int pages){
        this.name = name;
        this.pages = pages;
    }
    public Book(String name){
        this.name = name;
        this.pages = 0;
    }
    public Book(){
        this.name = "Колобок";
        this.pages = 0;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getPages() {
        return pages;
    }
    public String toString(){
        return this.name+", pages "+this.pages;
    }
    public void printAmountOfBlocks() {
        System.out.println(name + " has " +  getBlocks() + " blocks");
    }

    private int getBlocks(){
        return pages % 16==0 ? pages / 16 : pages/16+1;
    }
}
