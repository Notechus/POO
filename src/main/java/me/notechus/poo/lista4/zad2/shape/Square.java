package me.notechus.poo.lista4.zad2.shape;

/**
 * @author Sebastian Paulus
 */
public class Square implements Shape {

    private int length;

    public Square(int length) {
        this.length = length;
    }

    @Override
    public String draw() {
        return "Square: " + length;
    }
}
