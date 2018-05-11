package me.notechus.poo.lista8.zad1;

/**
 * @author Sebastian Paulus
 */
public class CopyFileCommand extends AbstractFileCommand {

    private final String targetFileName;

    public CopyFileCommand(String sourceFileName, String targetFileName) {
        super(sourceFileName);
        this.targetFileName = targetFileName;
    }

    @Override
    public void execute() {
        MyFileUtils.copyFile(sourceFileName, targetFileName);
    }
}
