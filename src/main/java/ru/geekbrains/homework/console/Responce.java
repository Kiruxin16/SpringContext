package ru.geekbrains.homework.console;

public class Responce {

    private long id;
    private String command;

    public Responce(String command, long id) {
        this.command = command;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
