package ru.mephi.module05;

import java.util.ArrayList;

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


    public static void main(String[] args) {
/*
        Parent o1 = new Parent();
        o1.sout();
        Parent o2 = new Child();
        o2.sout();
        Child o3 = (Child) o2;
        o3.sout();
        */

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        System.out.println(a);

        settter(a);
        System.out.println(a);

    }

}
