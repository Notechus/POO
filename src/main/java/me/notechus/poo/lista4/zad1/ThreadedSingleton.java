package me.notechus.poo.lista4.zad1;

/**
 * @author Sebastian Paulus
 */
public class ThreadedSingleton {

    private static final ThreadLocal<ThreadedSingleton> instance = ThreadLocal.withInitial(ThreadedSingleton::new);

    public static ThreadedSingleton getInstance() {
        return instance.get();
    }
}
