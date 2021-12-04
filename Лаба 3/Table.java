package ru.mirea.lab3;

public class Table extends Furniture {

    public Table(String material, String shape, String color) {
        super(material, shape, color);
    }

    @Override
    public void showInfo() {
        System.out.println("Table, material: "+ super.getMaterial() + "\tshape: " + super.getShape() + "\tcolor: "+ super.getColor());
    }

}
