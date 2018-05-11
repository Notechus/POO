package me.notechus.poo.lista8.zad1;

import java.util.concurrent.BlockingQueue;

/**
 * @author Sebastian Paulus
 */
public class CommandProducer {

    private final BlockingQueue<Command> commands;

    public CommandProducer(BlockingQueue<Command> commands) {
        this.commands = commands;
    }
}
