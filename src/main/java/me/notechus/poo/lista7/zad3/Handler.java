package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public interface Handler {

    void setNext(Handler handler);

    void execute(String email);
}
