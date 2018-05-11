package me.notechus.poo.lista8.zad1;

/**
 * @author Sebastian Paulus
 */
public class FTPCommand extends AbstractFileCommand {

    private String serverURL;

    public FTPCommand(String sourceFileName, String serverURL) {
        super(sourceFileName);
        this.serverURL = serverURL;
    }

    @Override
    public void execute() {
        MyFileUtils.downloadFileFromFTP(sourceFileName, serverURL);
    }
}
