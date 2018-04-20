package me.notechus.poo.lista5.zad3;

import me.notechus.poo.lista4.zad3.Plane;
import org.junit.Test;

/**
 * @author notechus.
 */
public class AirportProxyTest {

    @Test
    public void testLoggingProxy() throws IllegalAccessException {
        Plane plane = AirportLoggingProxy.acquirePlane();
        AirportLoggingProxy.releasePlane(plane);
    }

    @Test
    public void testProtectedProxy() throws IllegalAccessException {
        Plane plane = AirportProtectedProxy.acquirePlane();
        AirportProtectedProxy.releasePlane(plane);
    }
}