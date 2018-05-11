package me.notechus.poo.lista8.zad1;

/**
 * @author Sebastian Paulus
 */
public class HTTPCommand extends AbstractFileCommand {

    private String serverURL;

    public HTTPCommand(String sourceFileName, String serverURL) {
        super(sourceFileName);
        this.serverURL = serverURL;
    }

    @Override
    public void execute() {
        MyFileUtils.downloadFileFromHTTP(sourceFileName, serverURL);
    }
}
