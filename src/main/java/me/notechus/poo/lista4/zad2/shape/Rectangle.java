package me.notechus.poo.lista4.zad2.shape;

/**
 * @author Sebastian Paulus
 */
public class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String draw() {
        return "Rectangle: " + width + " , " + height;
    }
}
