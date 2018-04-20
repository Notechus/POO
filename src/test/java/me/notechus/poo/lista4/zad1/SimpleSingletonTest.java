package me.notechus.poo.lista4.zad1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sebastian Paulus
 */
public class SimpleSingletonTest {

    @Test
    public void testSimpleSingleton() {
        SimpleSingleton instance = SimpleSingleton.getInstance();

        SimpleSingleton secondInstance = SimpleSingleton.getInstance();

        assertEquals(instance, secondInstance);
    }
}