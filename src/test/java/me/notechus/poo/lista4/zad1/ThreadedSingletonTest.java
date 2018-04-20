package me.notechus.poo.lista4.zad1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * @author Sebastian Paulus
 */
public class ThreadedSingletonTest {

    private ThreadedSingleton singleton;
    private ThreadedSingleton secondInstance;

    @Test
    public void testThreadedSingleton() throws InterruptedException {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());

        t1.start();
        t2.start();

        Thread.sleep(1000L);

        assertNotEquals(singleton, secondInstance);
    }

    class Thread1 implements Runnable {

        @Override
        public void run() {
            singleton = ThreadedSingleton.getInstance();
        }
    }

    class Thread2 implements Runnable {

        @Override
        public void run() {
            secondInstance = ThreadedSingleton.getInstance();
        }
    }
}