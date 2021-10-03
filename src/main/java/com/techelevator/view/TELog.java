package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TELog {
    private static File searchLog = new File("Log.txt");

    Scanner userInput = new Scanner(System.in);

    public static void log(String message) {
        try {
            PrintWriter writer = new PrintWriter(searchLog);
            writer.println(message);
            writer.close();
        } catch (TELogException | FileNotFoundException e) {
            System.out.println("Error has occurred");
        }
    }
}
