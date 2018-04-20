package me.notechus.poo.lista4.zad2.worker;

import me.notechus.poo.lista4.zad2.shape.Shape;
import me.notechus.poo.lista4.zad2.shape.ShapeType;

/**
 * @author Sebastian Paulus
 */
public interface ShapeFactoryWorker {

    ShapeType getShapeType();

    boolean isValid(Object... parameters);

    Shape create(Object... parameters);
}
