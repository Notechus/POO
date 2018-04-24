package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public class OrderEmailHandler extends AbstractHandler {
    @Override
    public void execute(String email) {
        System.out.println("Got an order. Forwarding to O2C team.");
        setNext(new StorageHandler());
        getNext().execute(email);
    }
}
