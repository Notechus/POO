package me.notechus.poo.lista4.zad2.shape;

/**
 * @author Sebastian Paulus
 */
public class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String draw() {
        return "Circle: " + radius;
    }
}
