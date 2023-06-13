package ru.geekbrains.lesson2.example;

public class Find {
    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("find " + find(array, 5));

        System.out.println("binarySearch " + binarySearch(array, 5));
    }

    /**
     * @param array массив входных данных
     * @param value искомое число
     * @return позицию в массиве
     * @apiNote Алгоритм простого поиска, сложность O(n)
     */
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    /**
     * @param array массив входных данных
     * @param value искомое число
     * @param min   начальный элемент массива
     * @param max   конечный элемент массива
     * @return позицию в массиве
     * @apiNote Бинарный поиск, разделяй и властвуй, через рекурсию, сложность O(log n)
     */
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midpoint;

        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }
}
