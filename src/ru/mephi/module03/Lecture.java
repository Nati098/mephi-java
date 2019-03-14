package ru.mephi.module03;

public class Lecture {

    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        System.out.println(a == b);
        System.out.println(a == c);

        b = b+"";
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }


}
