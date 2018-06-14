package me.notechus.poo.lista8.zad3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author notechus.
 */
public class XMLDataAccessHandler implements DataAccessHandler {

    private static final Logger log = LoggerFactory.getLogger(XMLDataAccessHandler.class);

    @Override
    public void connect() {
        log.info("Opening xml file");
    }

    @Override
    public Object getData() {
        return Arrays.asList("A", "AA", "AAAAA", "AAAAAAAAAA", "BBBBBBBBBBBBBBBBBBBBBBBBBBBBB", "CC", "D");
    }

    @Override
    public Object processData(Object data) {
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
    public void close() {
        log.info("Opening xml resource");
    }
}
