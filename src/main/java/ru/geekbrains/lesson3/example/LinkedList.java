package ru.geekbrains.lesson3.example;

public class LinkedList {
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
     * @apiNote метод выводит n-е число с конца односвязного списка, предварительно не узнавая его размер
     * @param n
     * @return значение
     */
    public int getNthNodeFromEnd(int n) {
        Node p = head;
        Node q = head;

        for (int i = 0; i < n; i++) {
            if (q == null) {
                return -1; // если список короче, чем n элементов
            }
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p.value;
    }

    /**
     * @apiNote Метод печатает на экран результат получения метода getNthNodeFromEnd()
     * @param n
     */
    public void printNthNodeFromEnd(int n) {
        int result = getNthNodeFromEnd(n);
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("Список короче, чем " + n + " элементов");
        }
    }
}
