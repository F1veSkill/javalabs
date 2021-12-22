package ru.mirea.lab9;

import java.util.Scanner;

public class Main {

    public void getKey() {
        int i = 0;
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter Key ");
        String key = myScanner.nextLine();
        while (i < 1)
            try {
                printDetails(key);
            } catch (Exception e) {
                i++;
            }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}
