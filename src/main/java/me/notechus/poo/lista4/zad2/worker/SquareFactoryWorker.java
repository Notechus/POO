package me.notechus.poo.lista4.zad2.worker;

import me.notechus.poo.lista4.zad2.shape.Shape;
import me.notechus.poo.lista4.zad2.shape.ShapeType;
import me.notechus.poo.lista4.zad2.shape.Square;

/**
 * @author Sebastian Paulus
 */
public class SquareFactoryWorker implements ShapeFactoryWorker {

    @Override
    public ShapeType getShapeType() {
        return ShapeType.SQUARE;
    }

    @Override
    public boolean isValid(Object... parameters) {
        return parameters.length == 1 && parameters[0] instanceof Integer;
    }

    @Override
    public Shape create(Object... parameters) {
        return new Square((Integer) parameters[0]);
    }
}
