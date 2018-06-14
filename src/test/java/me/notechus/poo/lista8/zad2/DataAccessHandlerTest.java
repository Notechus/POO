package me.notechus.poo.lista8.zad2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author notechus.
 */
public class DataAccessHandlerTest {

    @Test
    public void testDBAccess() {
        DataAccessHandler handler = new DBDataAccessHandler();

        Object result = handler.execute();

        assertEquals(6, result);
    }

    @Test
    public void testXMLAccess() {
        DataAccessHandler handler = new XMLDataAccessHandler();

        Object result = handler.execute();

        assertEquals("BBBBBBBBBBBBBBBBBBBBBBBBBBBBB", result);
    }

}