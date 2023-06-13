package ru.geekbrains.lesson1.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) throws Exception {
        // f(4);
        System.out.println("fibRec(4) = " + fibRec(4));

    }

    /**
     * @param n - число
     * @return число фибоначчи
     * @apiNote Алгоритм поиска нужного числа последовательности Фибоначчи
     * Экспоненциальная сложность
     * 1 1 2 3 5 8 ...
     */
    static int fibRec(int n){
        if (n <= 2) {
            return 1;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    /**
     * @apiNote базовая программа нахождения рекурсии, обьяснение в лекции 1 тайминг 1:07
     * @param n
     */
    static void f(int n){
        System.out.println(n);
        if(n >= 3){
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }
}
