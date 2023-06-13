package ru.geekbrains.lesson1.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Ex5 {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        System.out.println("fibLin(n) = " + fibLin(4, counter));
        System.out.println("counter = " + counter);
    }

    /**
     * @param n число
     * @return
     * @apiNote Линейная сложность Числа Фибонначи без рекурсии.
     */
    static int fibLin(int n, AtomicInteger counter) {
        if (n <= 2) {
            return 1;
        } else {
            final int[] numbers = new int[n];
            numbers[0] = 1;
            numbers[1] = 1;
            for (int i = 2; i < numbers.length; i++) {
                counter.incrementAndGet();
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            return numbers[n - 1];
        }
    }
}
