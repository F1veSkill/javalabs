package ru.mirea.lab3;

public class Cupboard extends Furniture {

    public Cupboard(String material, String shape, String color) {
        super(material, shape, color);
    }

    @Override
    public void showInfo() {
        System.out.println("Cupboard, material: "+ super.getMaterial() + " shape: " + super.getShape() + " color: "+ super.getColor());
    }

}
