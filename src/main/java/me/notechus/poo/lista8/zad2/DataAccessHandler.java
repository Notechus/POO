package me.notechus.poo.lista8.zad2;

/**
 * @author notechus.
 */
public abstract class DataAccessHandler {

    protected abstract void connect();

    protected abstract Object getData();

    protected abstract Object processData(Object data);

    protected abstract void close();

    public final Object execute() {
        connect();
        Object o = getData();
        Object res = processData(o);
        close();

        return res;
    }
}
