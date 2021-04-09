package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Logger;

public class Part2 {

    public static final File FILE_1 = new File("part2.txt");
    public static final File FILE_2 = new File("part2_sorted.txt");
    public static final String ERROR = "Ошибка";


    public static void main(String[] args) {

        createSortedArray(createArray());

        Logger log = Logger.getLogger(Part2.class.getName());

        try (Scanner scanner = new Scanner(FILE_1);
             Scanner scanner2 = new Scanner(FILE_2)) {

            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            sb.append("input ==> ");
            while (scanner.hasNextInt()) {
                sb.append(scanner.nextInt() + " ");
            }

            sb2.append("output ==> ");
            while (scanner2.hasNextInt()) {
                sb2.append(scanner2.nextInt() + " ");
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1));
            System.out.println(sb2.deleteCharAt(sb2.length() - 1));

        } catch (IOException e) {
            log.info(ERROR);

        }

    }

    public static int[] createArray() {
        Logger log = Logger.getLogger(Part2.class.getName());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("part2.txt"));) {

            for (int i = 0; i < 10; i++) {
                int a = new SecureRandom().nextInt(50);
                bw.write(a + " ");
            }

        } catch (IOException e) {
            log.info(ERROR);

        }

        int[] dataArray = new int[10];
        try (Scanner scanner = new Scanner(FILE_1);) {

            int i = 0;
            while (scanner.hasNextInt()) {
                dataArray[i] = scanner.nextInt();
                i++;
            }

        } catch (IOException e) {
            log.info(ERROR);
        }
        return dataArray;
    }

    public static void createSortedArray(int[] dataArray) {
        Logger log = Logger.getLogger(Part2.class.getName());
        for (int j = 0; j < dataArray.length; j++) {
            for (int i = 1; i < dataArray.length; i++) {
                if (dataArray[i] < dataArray[i - 1]) {
                    int tmp = dataArray[i];
                    dataArray[i] = dataArray[i - 1];
                    dataArray[i - 1] = tmp;
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("part2_sorted.txt"))) {
            for (int i = 0; i < 10; i++) {
                bw.write(dataArray[i] + " ");
            }

        } catch (IOException e) {
            log.info(ERROR);
        }


    }
}


