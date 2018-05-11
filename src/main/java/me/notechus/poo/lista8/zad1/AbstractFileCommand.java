package me.notechus.poo.lista8.zad1;

/**
 * @author Sebastian Paulus
 */
public abstract class AbstractFileCommand implements Command {

    protected String sourceFileName;

    public AbstractFileCommand(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }
}
