package ru.geekbrains.lesson1.example;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("sumN(n) = " + sumN(n));
    }

    /**
     * @param n до какого числа считаем сумму
     * @return sum сумма всех чисел
     * @apiNote Алгоритм суммы всех чисел от 1 до N, согласно свойствам линейной сложности.
     */
    static int sumN(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }


}
