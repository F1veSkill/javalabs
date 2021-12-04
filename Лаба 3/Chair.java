package ru.mirea.lab3;

public class Chair extends Furniture{

    public Chair(String material, String shape, String color) {
        super(material, shape, color);
    }

    @Override
    public void showInfo() {
        System.out.println("Chair, material: " + super.getMaterial() + " shape: " + super.getShape() + " color: "+ super.getColor());
    }

}
