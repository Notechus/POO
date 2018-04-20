package me.notechus.poo.lista4.zad2.worker;

import me.notechus.poo.lista4.zad2.shape.Circle;
import me.notechus.poo.lista4.zad2.shape.Shape;
import me.notechus.poo.lista4.zad2.shape.ShapeType;

/**
 * @author Sebastian Paulus
 */
public class CircleFactoryWorker implements ShapeFactoryWorker {
    @Override
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }

    @Override
    public boolean isValid(Object... parameters) {
        return parameters.length == 1 && parameters[0] instanceof Integer;
    }

    @Override
    public Shape create(Object... parameters) {
        return new Circle((Integer) parameters[0]);
    }
}
