package me.notechus.poo.lista5.zad3;

import me.notechus.poo.lista4.zad3.Airport;
import me.notechus.poo.lista4.zad3.Plane;

import java.time.LocalDateTime;

/**
 * @author notechus.
 */
public class AirportProtectedProxy {

    public static Plane acquirePlane() throws IllegalAccessException {
        if (isAvailable()) {
            return Airport.acquirePlane();
        } else {
            throw new IllegalAccessException("Airport closed");
        }
    }

    public static void releasePlane(Plane p) throws IllegalAccessException {
        if (isAvailable()) {
            Airport.releasePlane(p);
        } else {
            throw new IllegalAccessException("Airport closed");
        }
    }

    private static boolean isAvailable() {
        int hour = LocalDateTime.now().getHour();
        return hour >= 8 && hour <= 22;
    }
}
