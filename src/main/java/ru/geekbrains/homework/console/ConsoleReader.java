package ru.geekbrains.homework.console;

import java.util.Scanner;

public class ConsoleReader {



    Scanner scanner;
    public ConsoleReader(){
        scanner=new Scanner(System.in);

    }
    public Responce readCommand(){
        String[] strArr =scanner.nextLine().split(" ",2);
        if(strArr.length==1){
            return new Responce(strArr[0],0);
        }
        try{
            return new Responce(strArr[0],Long.parseLong(strArr[1]));

        } catch (Exception e) {
            return new Responce(API.FAIL, 0);
        }

    }
}
