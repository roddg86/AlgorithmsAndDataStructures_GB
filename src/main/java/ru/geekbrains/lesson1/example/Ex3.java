package ru.geekbrains.lesson1.example;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("sumCount(n) = " + sumCount(n));
    }

    /**
     * @apiNote Алгоритм поиска всех доступных комбинаций (посчитать количество) для 4 кубиков с количеством граней N.
     * Экспоненциальная сложность.
     * @param number количество граней поданое на вход.
     * @return сумма комбинаций.
     */
    static int sumCount(int number){
        int count = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                for (int k = 0; k < number; k++) {
                    for (int l = 0; l < number; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
