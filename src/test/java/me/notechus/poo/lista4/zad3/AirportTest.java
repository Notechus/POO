package me.notechus.poo.lista4.zad3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sebastian Paulus
 */
public class AirportTest {

    private static final int CAPACITY = 4;

    @Before
    public void setUp() {
        Airport.resetPool();
    }

    @Test
    public void airportUsageTest() throws IllegalAccessException {
        assertEquals(CAPACITY, Airport.availableResourcesCount());
        Plane p1 = Airport.acquirePlane();

        assertEquals(CAPACITY - 1, Airport.availableResourcesCount());
        Airport.releasePlane(p1);
        assertEquals(CAPACITY, Airport.availableResourcesCount());
    }

    @Test(expected = IllegalAccessException.class)
    public void airportCannotExhaustPoolTest() throws IllegalAccessException {
        Airport.acquirePlane();
        Airport.acquirePlane();
        Airport.acquirePlane();
        Airport.acquirePlane();
        Airport.acquirePlane();
    }

}