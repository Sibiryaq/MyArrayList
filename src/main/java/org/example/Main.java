package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("первый");
        strings.add(0, "теперь я первый");
        strings.add("второй");
        strings.add("третий");
        System.out.println(strings);
        strings.remove(2);
        System.out.println("третий ушел, остались: ");
        for (String s: strings) {
            System.out.print(s + " ");
        }
        System.out.println();

        strings.sort(String::compareTo); //наоборот, т.к В раньше Т
        System.out.println(strings);


    }
}