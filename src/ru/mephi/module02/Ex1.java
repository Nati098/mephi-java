package ru.mephi.module02;

class Ex1 {

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        for(int i=1; i < 11; i++){
            System.out.println(n+"*"+i+" = "+(n*i));
        }
    }
}