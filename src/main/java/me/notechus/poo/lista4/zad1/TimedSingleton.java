package me.notechus.poo.lista4.zad1;

import java.time.Instant;

/**
 * @author Sebastian Paulus
 */
public class TimedSingleton {

    private static final long TIME_THRESHOLD_MILLIS = 5000L;
    private static TimedSingleton instance;
    private static Instant lastChanged;

    public static TimedSingleton getInstance() {
        if (instance == null || Instant.now().plusMillis(TIME_THRESHOLD_MILLIS).isAfter(lastChanged)) {
            instance = new TimedSingleton();
            lastChanged = Instant.now();
        }

        return instance;
    }
}
