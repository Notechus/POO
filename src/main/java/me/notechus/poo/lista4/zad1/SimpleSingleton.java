package me.notechus.poo.lista4.zad1;

/**
 * @author Sebastian Paulus
 */
public class SimpleSingleton {

    private static SimpleSingleton instance;

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    private SimpleSingleton() {

    }
}
