package com.epam.rd.java.basic.practice4;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    public static final String ERROR="Ошибка";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Part6.class.getName());

        try (Scanner scanner = new Scanner(new File("part6.txt"), "cp1251");) {

            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }

        } catch (IOException ex) {
            log.info(ERROR);
        }
        String input = sb.toString().trim();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {

            while (true) {
                String s = bufferedReader.readLine();

                if (s.equals("stop")) break;
                else if (s.equals("Latn")) {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(s).append(": ");
                    Pattern pattern = Pattern.compile("[A-Za-z]+",Pattern.UNICODE_CHARACTER_CLASS);
                    Matcher matcher = pattern.matcher(input);
                    while (matcher.find()) {
                        sb1.append(matcher.group()).append(" ");
                    }
                    System.out.println(sb1);

                } else if (s.equals("Cyrl")) {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(s).append(": ");
                    Pattern pattern = Pattern.compile("[^A-Za-z\\W]+", Pattern.UNICODE_CHARACTER_CLASS);
                    Matcher matcher = pattern.matcher(input);
                    while (matcher.find()) {
                        sb1.append(matcher.group()).append(" ");
                    }
                    System.out.println(sb1);

                } else {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append(s).append(": Incorrect input");
                    System.out.println(sb1);
                }
            }

        } catch (IOException e) {
            log.info(ERROR);

        }


    }

}