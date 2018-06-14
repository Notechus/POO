package me.notechus.poo.lista8.zad2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author notechus.
 */
public class DBDataAccessHandler extends DataAccessHandler {

    private static final Logger log = LoggerFactory.getLogger(DBDataAccessHandler.class);

    @Override
    protected void connect() {
        log.info("Connecting to database");
    }

    @Override
    protected Object getData() {
        return Arrays.asList("1", "2", "3");
    }

    @Override
    protected Object processData(Object data) {
        if (List.class.isAssignableFrom(data.getClass())) {
            List<String> list = (List<String>) data;
            int sum = list.stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
            log.info("Sum of data from table is: {}", sum);
            return sum;
        }

        return null;
    }

    @Override
    protected void close() {
        log.info("Closing connection to database");
    }
}
