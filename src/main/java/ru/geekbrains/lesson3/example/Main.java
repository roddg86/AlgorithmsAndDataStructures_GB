package ru.geekbrains.lesson3.example;

import ru.geekbrains.lesson3.homework.Hw3;

public class Main {

    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//
//        linkedList.addFirst(1);
//        linkedList.addFirst(7);
//        linkedList.addFirst(9);
//        linkedList.addFirst(33);
//        linkedList.addFirst(55);
//        linkedList.addFirst(66);
//        linkedList.addFirst(77);
//
//        linkedList.addLast(60);
//        linkedList.addLast(70);
//        linkedList.addLast(80);
//        linkedList.addLast(90);
//
//        linkedList.printList();
//
//        System.out.println("linkedList.contains(55) = " + linkedList.contains(60));
//        System.out.println("linkedList.contains(165) = " + linkedList.contains(165));
//        System.out.println("linkedList.contains(75) = " + linkedList.contains(75));
//
//        linkedList.printList();
//
//        linkedList.removeLast();
//        linkedList.printList();
//        linkedList.remove();
//        linkedList.printList();

//        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.addFirst(1);
//        doubleLinkedList.addFirst(2);
//        doubleLinkedList.printList();
//        doubleLinkedList.remove();
//        doubleLinkedList.printList();
//        doubleLinkedList.addLast(3);
//        doubleLinkedList.addLast(4);
//        doubleLinkedList.addLast(5);
//        doubleLinkedList.printList();
//        doubleLinkedList.removeLast();
//        doubleLinkedList.printList();

//        linkedList.printNthNodeFromEnd(3);
//
//        linkedList.reverse();
//
//        linkedList.printList();
//
//        linkedList.printNthNodeFromEnd(3);

        Hw3 linkedListHw3 = new Hw3();
        linkedListHw3.addFirst(111);
        linkedListHw3.addFirst(222);
        linkedListHw3.addFirst(333);
        linkedListHw3.addFirst(444);

        linkedListHw3.printList();

        linkedListHw3.printNthNodeFromEnd(3);

        linkedListHw3.reverse();

        linkedListHw3.printList();

        linkedListHw3.printNthNodeFromEnd(3);

    }
}