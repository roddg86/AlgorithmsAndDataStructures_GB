package ru.geekbrains.lesson3.homework;

import ru.geekbrains.lesson3.example.LinkedList;

public class Hw3 {
    /*    Всем привет, вот задание на домашнее закрепление:
       - Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).
       - (Необязательное)* попробуйте вывести n-е число с конца односвязного списка, предварительно не узнавая его размер : )*/

    Node head;

    public class Node {
        int value;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void remove() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * @param value предаваемое значение
     * @return
     * @apiNote проверка, есть ли элемент
     */
    public boolean contains(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
    }

    public void removeLast() {
        if (head != null) {
            Node currentNode = head;
            if (currentNode.next == null) {
                head = null;
            }
            while (currentNode.next != null) {
                if (currentNode.next.next == null) {
                    currentNode.next = null;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
    }

    /**
     * @apiNote метода разворота односвязного списка
     */
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    /**
     * @param number число
     * @return значение
     * @apiNote метод выводит n-е число с конца односвязного списка, предварительно не узнавая его размер
     */
    public int getNthNodeFromEnd(int number) {
        Node away = head;
        Node moves = head;

        for (int i = 0; i < number; i++) {
            if (moves == null) {
                return -1; // если список короче, чем n элементов
            }
            moves = moves.next;
        }

        while (moves != null) {
            away = away.next;
            moves = moves.next;
        }

        return away.value;
    }

    /**
     * @param number число
     * @apiNote Метод печатает на экран результат получения метода getNthNodeFromEnd()
     */
    public void printNthNodeFromEnd(int number) {
        int result = getNthNodeFromEnd(number);
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("Список короче, чем " + number + " элементов");
        }
    }
}