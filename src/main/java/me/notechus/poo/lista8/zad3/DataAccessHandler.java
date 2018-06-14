package me.notechus.poo.lista8.zad3;

/**
 * @author notechus.
 */
public interface DataAccessHandler {

    void connect();

    Object getData();

    Object processData(Object data);

    void close();
}
