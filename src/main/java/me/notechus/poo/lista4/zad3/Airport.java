package me.notechus.poo.lista4.zad3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Sebastian Paulus
 */
public class Airport {

    private static List<Plane> planePool;
    private static List<Plane> lockedPlanes;

    static {
        resetPool();
    }

    public static Plane acquirePlane() throws IllegalAccessException {
        if (planePool.isEmpty()) {
            throw new IllegalAccessException("No more planes left");
        }

        Plane p = planePool.remove(0);
        lockedPlanes.add(p);

        return p;
    }

    public static void releasePlane(Plane p) {
        lockedPlanes.remove(p);
        planePool.add(p);
    }

    public static int availableResourcesCount() {
        return planePool.size();
    }

    static void resetPool() {
        planePool = IntStream.
                rangeClosed('A', 'D').mapToObj(c -> "" + (char) c)
                .map(Plane::new)
                .collect(Collectors.toList());
        lockedPlanes = new ArrayList<>();
    }
}
