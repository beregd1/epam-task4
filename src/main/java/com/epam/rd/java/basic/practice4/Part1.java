package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Part1 {

    // getting input string from the file
    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

    // deleting the first two characters of each word with the length of 4 and more characters
    public static void convert() {
        try (BufferedReader in = new BufferedReader(new FileReader("part1.txt"))) {

            String line;
            StringBuilder result = new StringBuilder();

            while ((line = in.readLine()) != null) {
                String[] wordsInLine = line.split("[.,!?\\-\\s\\n]+");

                for (String string : wordsInLine) {
                    if (isLongerThanFour(string) && defineLocale(string) == "latn") {
                        result.append(string.substring(2) + " ");
                    } else if (isLongerThanFour(string) && defineLocale(string) == "cyrl") {
                        result.append(string.substring(4) + " ");
                    } else {
                        result.append(string + " ");
                    }
                }
            }

            System.out.println(result);
        }catch(IOException e){
            e.getMessage();
        }
    }

    // checking for right length of current word
    public static boolean isLongerThanFour(String string){
        return string.length() >= 4;
    }

    // define language of input word(one of cyrillic of latin languages)
    private static String defineLocale(String string) {
        char ch = string.charAt(0);

        if (Character.isAlphabetic(ch)) {
            if (Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.CYRILLIC)) {
                return "cyrl";
            } else if (Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.BASIC_LATIN)){
                return "latn";
            }
        }
        return "none";
    }

    public static void main(String[] args){
        Part1.convert();
    }

}
