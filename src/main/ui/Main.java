package ui;

import exceptions.Nonintegerexception;
import model.Question;
import ui.App;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws Nonintegerexception {
        try {
            new App();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}