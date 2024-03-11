package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        MyArrayList<String> names = new MyArrayList<>();
        names.add("Г");
        names.add("Б");
        names.add("В");
        names.add("А");


        for (String s : names) {
            System.out.println(s);
        }


        names.quickSort(Comparator.naturalOrder());
        for (String s : names) {
            System.out.println(s);
        }

    }
}