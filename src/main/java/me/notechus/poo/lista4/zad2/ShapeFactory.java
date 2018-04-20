package me.notechus.poo.lista4.zad2;

import me.notechus.poo.lista4.zad2.shape.Shape;
import me.notechus.poo.lista4.zad2.shape.ShapeType;
import me.notechus.poo.lista4.zad2.worker.ShapeFactoryWorker;
import me.notechus.poo.lista4.zad2.worker.SquareFactoryWorker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sebastian Paulus
 */
public class ShapeFactory {

    private Map<ShapeType, ShapeFactoryWorker> workers = new HashMap<>();

    public ShapeFactory() {
        workers.put(ShapeType.SQUARE, new SquareFactoryWorker());
    }

    public void registerWorker(ShapeFactoryWorker worker) {
        workers.putIfAbsent(worker.getShapeType(), worker);
    }

    public Shape createShape(ShapeType shape, Object... parameters) {
        ShapeFactoryWorker worker = workers.get(shape);
        if (worker != null && worker.isValid(parameters)) {
            return worker.create(parameters);
        }

        throw new UnsupportedOperationException("Cannot find worker for shape " + shape);
    }
}
