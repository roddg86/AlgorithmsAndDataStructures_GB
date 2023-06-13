package ru.geekbrains.lesson1.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        for (int i = 0; i < numbers; i++) {
            if(primeNumber(i)){
                System.out.print(i + " ");
            }
        }
    }

    /**
     * @param max
     * @return List
     * @apiNote Алгоритм поиска простых чисел
     * Квадратична сложность
     */
    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }

    /**
     * @apiNote Алгоритм проверки числа на простоту
     * @param number число до которого необходимо выводить простые числа
     * @return boolean
     */
    static boolean primeNumber(int number){
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
