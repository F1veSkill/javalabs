package ru.mirea.lab3;

public abstract class Furniture{

    private String material;
    private String shape;
    private String color;


    protected Furniture(String material, String shape, String color) {
        this.material = material;
        this.shape = shape;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public abstract void showInfo();
}
