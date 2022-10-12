package ru.geekbrains.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.homework.config.ContextConfig;
import ru.geekbrains.homework.console.API;
import ru.geekbrains.homework.console.ConsoleLoop;

public class AppMain {
    public static void main(String[] args) {
    new ConsoleLoop().start();

    }
}
