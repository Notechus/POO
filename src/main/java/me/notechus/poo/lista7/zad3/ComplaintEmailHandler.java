package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public class ComplaintEmailHandler extends AbstractHandler {
    @Override
    public void execute(String email) {
        System.out.println("Got complaint. Forwarding to support team.");
        setNext(new StorageHandler());
        getNext().execute(email);
    }
}
