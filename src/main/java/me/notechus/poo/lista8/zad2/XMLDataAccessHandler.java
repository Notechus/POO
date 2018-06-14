package me.notechus.poo.lista8.zad2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author notechus.
 */
public class XMLDataAccessHandler extends DataAccessHandler {

    private static final Logger log = LoggerFactory.getLogger(XMLDataAccessHandler.class);

    @Override
    protected void connect() {
        log.info("Opening xml file");
    }

    @Override
    protected Object getData() {
        return Arrays.asList("A", "AA", "AAAAA", "AAAAAAAAAA", "BBBBBBBBBBBBBBBBBBBBBBBBBBBBB", "CC", "D");
    }

    @Override
    protected Object processData(Object data) {
        if (List.class.isAssignableFrom(data.getClass())) {
            List<String> list = (List<String>) data;
            String longest = list.stream()
                    .reduce("", (a, b) -> a.length() > b.length() ? a : b);
            log.info("Longest word in xml is: {}", longest);
            return longest;
        }
        return null;
    }

    @Override
    protected void close() {
        log.info("Opening xml resource");
    }
}
