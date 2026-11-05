package main.java.app;

import main.java.app.files.FileTask;
import main.java.app.reflection.Invoker;

public class Main {
    public static void main(String[] args){
        System.out.println("Задание №1");
        Invoker.invokerAnnotatedMethods();

        System.out.println("Задание №2");
        FileTask.runFileSystemTask();
    }
}
