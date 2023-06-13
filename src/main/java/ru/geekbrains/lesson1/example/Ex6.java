package ru.geekbrains.lesson1.example;

import java.util.Date;

public class Ex6 {

    private static Long time;

    public static void main(String[] args) {
        System.out.println("fibRec(4) = " + fibRec(4));
        System.out.println("fibLin(4) = " + fibLin(4));

        for (int i = 10; i < 500; i += 10) {
            Date startDate = new Date();
            fibRec(i);
            Date endDate = new Date();
            long duration1 = endDate.getTime() - startDate.getTime();
            Date startDate2 = new Date();
            fibLin(i);
            Date endDate2 = new Date();
            long duration2 = endDate2.getTime() - startDate2.getTime();
            System.out.println("fibRec(i) = " + duration1 + " fibLin(i) = " + duration2);
        }
    }

    /**
     * @param n число
     * @return
     * @apiNote Линейная сложность Числа Фибонначи без рекурсии.
     */
    static int fibLin(int n) {
        if (n <= 2) {
            return 1;
        } else {
            final int[] numbers = new int[n];
            numbers[0] = 1;
            numbers[1] = 1;
            for (int i = 2; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            return numbers[n - 1];
        }
    }

    /**
     * @param n - число
     * @return число фибоначчи
     * @apiNote Алгоритм поиска нужного числа последовательности Фибоначчи
     * Экспоненциальная сложность
     * 1 1 2 3 5 8 ...
     */
    static int fibRec(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
        System.out.println(time);

    }
}
