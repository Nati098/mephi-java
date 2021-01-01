package ru.mephi.module05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lecture {

    // <editor-fold defaultstate="collapsed" desc="Bikes & super.super">
    class Bike{
        int a;

        Bike(int a){
            this.a = a;
        }

        public String toString(){
            return "Hello"+a;
        }

    }

    class Bike1 extends Bike{
        int b;

        Bike1(int a, int b){
            super(a);
            this.b = b;
        }

        @Override
        public String toString(){
            return super.toString()+"b "+this.b;
        }
    }

    class Bike2 extends Bike1{
        int c;

        Bike2(int a, int b, int c){
            super(a,b);
            this.c = c;
        }

        @Override
        public String toString(){
            return super.toString()+"c "+c;
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Parent-child">
    //don't write STATIC for method, which you'd like to inherit
static class Parent{

        Parent(){}

        void sout(){
            System.out.println("Parent");
        }
    }

    static class Child extends Parent{

        Child(){}

        void sout(){
            // если будет static, то при Parent o = new Child будет вызываться метод PArent
            System.out.println("Child");
        }
    }

    // </editor-fold>

    private static void settter(ArrayList<Integer> c){
        c.add(8);
    }

    static int aaa(){
        int x=1;
        return x + ++x + (x = x++) +x;
    }

    static double add(double i){
        return i + 0.5;
    }

    class A{
        public A(int x){}
    }

    class B extends A{}

    public static void main(String[] args) {

//        for (double i=6; i > 0.003; i = Math.sqrt(i)){
//            System.out.print(i+" ");
//        }

        A a = new B();

//        System.out.println(aaa()); // должно вывести "[0, 1, 6, 7]"

    }

}
