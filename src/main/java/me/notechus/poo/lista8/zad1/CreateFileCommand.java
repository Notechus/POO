package me.notechus.poo.lista8.zad1;

/**
 * @author Sebastian Paulus
 */
public class CreateFileCommand extends AbstractFileCommand {

    public CreateFileCommand(String sourceFileName) {
        super(sourceFileName);
    }

    @Override
    public void execute() {
        MyFileUtils.createRandomFile(sourceFileName);
    }
}
