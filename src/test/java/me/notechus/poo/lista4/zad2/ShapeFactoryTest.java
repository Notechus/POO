package me.notechus.poo.lista4.zad2;

import me.notechus.poo.lista4.zad2.shape.Shape;
import me.notechus.poo.lista4.zad2.shape.ShapeType;
import me.notechus.poo.lista4.zad2.worker.RectangleFactoryWorker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sebastian Paulus
 */
public class ShapeFactoryTest {

    @Test
    public void shapeFactoryValidCreationTest() {
        ShapeFactory factory = new ShapeFactory();

        Shape shape = factory.createShape(ShapeType.SQUARE, 5);

        assertEquals("Square: 5", shape.draw());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shapeFactoryUnregisteredWorkerTest() {
        ShapeFactory factory = new ShapeFactory();

        factory.createShape(ShapeType.RECTANGLE, 5, 10);
    }

    @Test
    public void shapeFactoryValidCreationAfterRegisteringWorkerTest() {
        ShapeFactory factory = new ShapeFactory();

        factory.registerWorker(new RectangleFactoryWorker());

        Shape shape = factory.createShape(ShapeType.RECTANGLE, 5, 10);

        assertEquals("Rectangle: 5 , 10", shape.draw());
    }

}