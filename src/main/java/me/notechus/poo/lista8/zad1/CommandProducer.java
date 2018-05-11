package me.notechus.poo.lista8.zad1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author Sebastian Paulus
 */
public class CommandProducer implements Runnable {

    private final BlockingQueue<Command> commands;
    private static final long TIME = 1000L;
    private Random rand = new Random();
    private String[] fileNames = {"a", "b", "c", "d", "e"};
    private String serverURL = "localhost:8065";

    public CommandProducer(BlockingQueue<Command> commands) {
        this.commands = commands;
    }

    private Command produceCommand() {
        int i = rand.nextInt(4);
        switch (i) {
            case 1:
                int x = rand.nextInt(4);
                return new FTPCommand(fileNames[x], serverURL);
            case 2:
                int y = rand.nextInt(4);
                return new HTTPCommand(fileNames[y], serverURL);
            case 3:
                int z = rand.nextInt(4);
                return new CreateFileCommand(fileNames[z]);
            case 4:
                int a = rand.nextInt(4);
                int b = rand.nextInt(4);
                return new CopyFileCommand(fileNames[a], fileNames[b]);
            default:
                return null;
        }
    }

    @Override
    public void run() {
        Command c = produceCommand();
        if (c != null) {
            try {
                commands.put(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
