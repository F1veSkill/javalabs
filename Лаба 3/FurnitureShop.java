package ru.mirea.lab3;

import java.util.ArrayList;
import java.util.List;

public class FurnitureShop {

    private final List<Furniture> furniture;

    public void showMerchandise(){
       furniture.iterator().forEachRemaining(Furniture::showInfo);
    }


    FurnitureShop(){
        this.furniture = new ArrayList<>();
        furniture.add(new Chair("wood", "normal", "oak"));
        furniture.add(new Table("wood", "normal", "spruce"));
        furniture.add(new Cupboard("wood", "normal", "spruce"));
        furniture.add(new Chair("plastic", "normal", "oak"));
    }

    public static void main(String[] args) {
        new FurnitureShop().showMerchandise();
    }
}
