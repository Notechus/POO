package me.notechus.poo.lista4.zad1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * @author Sebastian Paulus
 */
public class TimedSingletonTest {

    @Test
    public void testTimedSingleton() throws InterruptedException {
        TimedSingleton instance = TimedSingleton.getInstance();

        Thread.sleep(5000L);

        TimedSingleton secondInstance = TimedSingleton.getInstance();

        assertNotEquals(instance, secondInstance);
    }
}