package me.notechus.poo.lista4.zad2.worker;

import me.notechus.poo.lista4.zad2.shape.Rectangle;
import me.notechus.poo.lista4.zad2.shape.Shape;
import me.notechus.poo.lista4.zad2.shape.ShapeType;

/**
 * @author Sebastian Paulus
 */
public class RectangleFactoryWorker implements ShapeFactoryWorker {
    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public boolean isValid(Object... parameters) {
        return parameters.length == 2 && parameters[0] instanceof Integer && parameters[1] instanceof Integer;
    }

    @Override
    public Shape create(Object... parameters) {
        return new Rectangle((Integer) parameters[0], (Integer) parameters[1]);
    }
}
