package me.notechus.poo.lista6.zad1;

import org.junit.Test;

/**
 * @author notechus.
 */
public class ILoggerFactoryTest {

    @Test
    public void testNullLogger() {
        ILogger logger = ILoggerFactory.getLogger(LogType.NONE);
        logger.log("I don't do anything");
    }

    @Test
    public void testConsoleLogger() {
        ILogger logger = ILoggerFactory.getLogger(LogType.CONSOLE);
        logger.log("I write to console");
    }

    @Test
    public void testFileLogger() {
        ILogger logger = ILoggerFactory.getLogger(LogType.FILE, "./log.txt");
        logger.log("I write to file");
    }

}