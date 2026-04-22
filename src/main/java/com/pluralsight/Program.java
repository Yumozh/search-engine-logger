package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LocalDateTime logTime = LocalDateTime.now();
        

        //Prompt actions
        String programStart = noteTime(logTime);
        System.out.println("Enter your search term (X to exit):");
        String userAction = scan.nextLine();

        //Note date and time of action



        //Write to a file

    }

    private static String noteTime(LocalDateTime logTime) {
        DateTimeFormatter exactTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return logTime.format(exactTime);
    }
}
