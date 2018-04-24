package me.notechus.poo.lista7.zad3;

/**
 * @author notechus.
 */
public abstract class AbstractHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    public Handler getNext() {
        return this.next;
    }
}
