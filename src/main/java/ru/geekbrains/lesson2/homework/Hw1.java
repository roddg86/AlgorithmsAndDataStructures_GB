package ru.geekbrains.lesson2.homework;

import java.util.Date;
import java.util.Random;

public class Hw1 {
    private static final Random random = new Random();
    private static long time;

    public static void main(String[] args) {
        int arr[] = prepareArray(30);
        printArray(arr);
        startTime();
        heapSort(arr);
        endTime();
        printArray(arr);
    }

    /**
     * @param arr входной массив
     * @apiNote Алгоритм пирамидальной сортировки
     *
     *
     *     Входные данные: 4, 10, 3, 5, 1
     *             4(0)
     *             /   \
     *         10(1)   3(2)
     *         /   \
     *     5(3)    1(4)
     *     Числа в скобках представляют индексы в представлении данных в виде массива.
     *     Применение процедуры heapify к индексу 1:
     *             4(0)
     *             /   \
     *         10(1)    3(2)
     *         /   \
     *      5(3)    1(4)
     *     Применение процедуры heapify к индексу 0:
     *             10(0)
     *             /  \
     *          5(1)  3(2)
     *          /   \
     *       4(3)    1(4)
     *     Процедура heapify вызывает себя рекурсивно для создания кучи сверху вниз.
     *
     */
    private static void heapSort(int[] arr) {
        int n = arr.length; // длинна массива

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Делаем сортировку, один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий максимальный элемент на последний элемент,
            // а на нулевой элемент ставим того кто стоял на последнем элементе
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, 0, i);
        }
    }

    /**
     * @param arr входной массив
     * @param i   корневой элемент кучи
     * @param n   размер массива
     * @apiNote Процедура для преобразования в двоичную кучу maxHeap
     * поддерева с корневым узлом i, что является
     * индексом в arr[].
     */
    private static void heapify(int[] arr, int i, int n) {
        int leftChild = i * 2 + 1; // левый ребенок
        int rightChild = i * 2 + 2; // правый ребенок
        int largest = i; // наибольший элемент

        // Если левый дочерний элемент больше корня
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // Если самый большой элемент не корень
        // Меняем местами если какой-то из детей оказался больше родителя
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно запускаем повторное преобразование в двоичную кучу затронутое поддерево
            heapify(arr, largest, n);
        }
    }


    /**
     * @param length длинна массива
     * @return массив
     * @apiNote формируем массив из рандомных чисел
     */
    public static int[] prepareArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    /**
     * @param arr входной массив
     * @apiNote печатаем массив
     */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    /**
     * @apiNote Время до метода
     */
    public static void startTime() {
        time = System.nanoTime();
    }

    /**
     * @apiNote Время после метода
     */
    public static void endTime() {
        time = System.nanoTime() - time;
        System.out.printf("HeapSort %,9.3f ms\n", time/1_000_000.0);
    }
}
