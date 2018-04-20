package me.notechus.poo.lista5.zad3;

import me.notechus.poo.lista4.zad3.Airport;
import me.notechus.poo.lista4.zad3.Plane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author notechus.
 */
public class AirportLoggingProxy {

    private static final Logger log = LoggerFactory.getLogger(AirportLoggingProxy.class);

    public static Plane acquirePlane() throws IllegalAccessException {
        Plane p = Airport.acquirePlane();
        log.info("Someone accessed Airport. The plane will be released {}", p);
        return p;
    }

    public static void releasePlane(Plane p) {
        log.info("Someone accessed Airport. The plane was given back {}", p);
        Airport.releasePlane(p);
    }
}
