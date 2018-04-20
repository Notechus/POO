package me.notechus.poo.lista6.zad1;

/**
 * @author notechus.
 */
public class ILoggerFactory {

    private ILoggerFactory() {

    }

    public static ILogger getLogger(LogType type, String... args) {
        switch (type) {
            case NONE:

                return new NullLogger();
            case CONSOLE:
                return new ConsoleLogger();
            case FILE:
                if (args.length == 0) {
                    throw new IllegalArgumentException("You have to specify file name when choosing file logger");
                }
                return new FileLogger(args[0]);
        }
        throw new UnsupportedOperationException("Cannot retrieve logger of type " + type);
    }
}
