package com.epam.rd.java.basic.practice4;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    public static void main(String[] args) {

        SentenceIterator sentenceIterator=new SentenceIterator();
        while (sentenceIterator.hasNext) {
            System.out.println(sentenceIterator.next());
        }


    }

    private static class SentenceIterator implements Iterator<String>  {
        Logger log = Logger.getLogger(SentenceIterator.class.getName());
        String input = getInput();
        Pattern pattern = Pattern.compile("\\p{Lu}[^.!?]+\\.", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        boolean hasNext = matcher.find();
        @Override
        public boolean hasNext() {
            return hasNext;
        }
        @Override
        public String next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            String next = matcher.group();
            hasNext = matcher.find();
            return next;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }



        public String getInput() {
            StringBuilder sb = new StringBuilder();

            try {
                Scanner scanner = new Scanner(new File("part4.txt"), "cp1251");
                while (scanner.hasNext()) {
                    sb.append(scanner.useDelimiter("[ "+ System.lineSeparator() + "]").next()).append(" ");
                }
                scanner.close();

            } catch (IOException ex) {
                log.info("Ошибка");

            }
            return sb.toString().trim();

        }
    }





}


