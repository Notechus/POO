package me.notechus.poo.lista8.zad1;

import java.util.concurrent.BlockingQueue;

/**
 * @author Sebastian Paulus
 */
public class CommandConsumer implements Runnable {

    private final BlockingQueue<Command> commands;
    private static final long TIME = 1000L;

    public CommandConsumer(BlockingQueue<Command> commands) {
        this.commands = commands;
    }

    private void consumeCommand() {
        try {
            Command command = this.commands.take();
            command.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            consumeCommand();
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
