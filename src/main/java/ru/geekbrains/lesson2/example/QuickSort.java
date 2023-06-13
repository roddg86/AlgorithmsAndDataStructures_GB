package ru.geekbrains.lesson2.example;

public class QuickSort {
    public static void main(String[] args) {

    }

    /**
     * @apiNote Алгоритм быстрой сортировки, через рекурсию, сложность поиска O(n * log n)
     * @param array массив входных данных
     * @param startPosition начальный элемент
     * @param endPosition конечный элемент
     */
    public static void sort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if(startPosition < rightPosition){
            sort(array,startPosition,rightPosition);
        }
    }
}
