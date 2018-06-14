package me.notechus.poo.lista8.zad3;

/**
 * @author notechus.
 */
public class DataAccessor {

    private DataAccessHandler handler;

    public DataAccessor(DataAccessHandler handler) {
        this.handler = handler;
    }

    public Object execute() {
        this.handler.connect();
        Object data = this.handler.getData();
        Object result = this.handler.processData(data);
        this.handler.close();

        return result;
    }
}
