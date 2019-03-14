package ru.mephi.module03;

/*
Вариант 1
Напишите программу, которая будет заменять значение каждого элемента массива
следующим наибольшим элементом (справа) в заданном массиве целых чисел.
Последний элемент заполнить значением 0.
Входные данные:
параметр: 55, 21, 110, 25, -5, 2, -10
Ожидаемый результат: 110, 110, 25, 2, 2, -10,0
 */

import java.util.Arrays;

public class Ex1 {

    public static int maxInArray(int[] arr){
        int maximum = arr[0];

        for (int i=1; i < arr.length; i++){
            if (arr[i] > maximum){
                maximum = arr[i];
            }
        }

        return maximum;
    }

    public static void main(String[] args) {
/*
        int[] arr = new int[args.length];
        for (int i=0; i < args.length; i++){
            arr[i] = Integer.parseInt(args[i]);
        }
*/
        int[] arr = {55, 21, 110, 25, -5, 2, -10};

        int[] res = new int[arr.length];
        for (int i=0; i < res.length - 1; i++){
            res[i] = maxInArray(Arrays.copyOfRange(arr, i+1, arr.length));
        }
        res[res.length-1] = 0;

        System.out.println(Arrays.toString(res));
    }

}
