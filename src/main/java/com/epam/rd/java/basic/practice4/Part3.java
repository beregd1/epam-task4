package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static final String PATTERN_1 = "[\\d+]*\\.\\d+";
    public static final String PATTERN_2 = "\\p{L}{2,}";
    public static final String PATTERN_3 = "\\b\\w\\b";
    public static final String PATTERN_4 = "(?<=\\s|^)\\d+(?=\\s|$)";


    public static void main(String[] args) {
        Logger log = Logger.getLogger(Part3.class.getName());
        String input=getString();


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {

            while (true) {
                String s = bufferedReader.readLine();
                if (s.equals("stop")) break;
                else if (s.equals("double")) {
                    matchReg(input,PATTERN_1);

                }else if (s.equals("String")) {
                    matchReg(input,PATTERN_2);

                }else if (s.equals("char")) {
                    matchReg(input,PATTERN_3);

                }else if (s.equals("int")) {
                    matchReg(input,PATTERN_4);

                } else {
                    System.out.println("Incorrect input");
                }
            }

        } catch (IOException e) {
            log.info("Ошибка");

        }

    }
    public static void matchReg(String input,String patternExm) {
        StringBuilder sb1 = new StringBuilder();
        Pattern pattern = Pattern.compile(patternExm,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sb1.append(matcher.group()).append(" ");
        }
        System.out.println(sb1);
    }
    public static String getString() {
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Part3.class.getName());

        try {
            Scanner scanner = new Scanner(new File("part3.txt"), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();

        } catch (IOException ex) {
            log.info("Ошибка");
        }
        return sb.toString().trim();
    }


}