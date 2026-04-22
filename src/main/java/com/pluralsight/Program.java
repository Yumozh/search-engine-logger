package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LocalDateTime logTime = LocalDateTime.now();
        String userAction = "";

        String launchTime = noteTime(logTime);
        writeToLog(launchTime + " launch ");
        //Prompt actions
        while (true) {

            System.out.println("Enter your search term (X to exit):");
            userAction = scan.nextLine();

            if(userAction.equalsIgnoreCase("exit") || userAction.equalsIgnoreCase("x"){
                break;
            }
            String actionTime = noteTime(logTime);
            writeToLog(actionTime + " search: " + userAction);
        }
        String terminationTime = noteTime(logTime);
        writeToLog(terminationTime + " exit");

        System.out.println("Program terminated.");

        }

    }

    private static String noteTime(LocalDateTime logTime) {
        DateTimeFormatter exactTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return logTime.format(exactTime);
    }
    private static void writeToLog(String message) {
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter("logs.txt", true))) {
            bufWriter.write(message);
            bufWriter.newLine();
        } catch (IOException e) {
            System.out.println("Could not write to log file.");
            throw new RuntimeException(e);
        }
}
