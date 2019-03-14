package ru.mephi.module03;

/*
Вариант 1
Программа должна выводить список неповторяющихся символов в строке.
Входные данные:
входной параметр: aalppy
Ожидаемый результат: l y
 */

import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {
        String in_str = "aalppy";
        String buf = "";
        String res = "";

        for (int i=1; i <= in_str.length(); i++){
            char cur_char = in_str.charAt(i-1);
            String substr = in_str.substring(i);

            // если этого символа нет в подстроке справа от символа
            if (substr.indexOf(cur_char) == -1){
                // если нет в буфере повторяющихся, то заносим в res
                if (buf.indexOf(cur_char) == -1){
                    res += cur_char + " ";
                }
            }
            else{
                // иначе добавляем в буфер повторяющихся значений
                buf += cur_char;
            }

        }


        System.out.println(res);
    }

}
