package me.notechus.poo.lista8.zad3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author notechus.
 */
public class DataAccessorTest {


    @Test
    public void testDataAccessorDB() {
        DataAccessor accessor = new DataAccessor(new DBDataAccessHandler());

        Object result = accessor.execute();

        assertEquals(6, result);
    }

    @Test
    public void testDataAccessorXML() {
        DataAccessor accessor = new DataAccessor(new XMLDataAccessHandler());
        Object result = accessor.execute();
    }
}