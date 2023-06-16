package ru.geekbrains.lesson3.example;

public class DoubleList {

    // начало списка
    Node head;

    // конец списка
    Node tail;

    /**
     * @apiNote Базовая структура односвязного списка
     * value значение
     * next ссылка на следующую ноду
     * previous ссылка на предыдущее значение
     */
    public class Node {
        int value;
        Node next;

        Node previous;

    }

    /**
     * @param value искомый элемент
     * @return найденный элемент
     * @apiNote метод поиска элементов в односвязном списке, перебор всех доступных детей, O(n)
     */
    public Node find(int value) {
        Node currentNode = head; // текущая нода
        // пока текущая нода не равна null, если текущая нода равна искомому значению вернем текущую ноду
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            // если этого не произошло, обновляем текущую ноду, присвоив следующую ноду по списку
            currentNode = currentNode.next;
        }
        // если элемента не нашлось вернуть null
        return null;
    }

    /**
     * @param value вставляемое значение
     * @param node  нода после которой вставляем значение
     * @apiNote Метод добавления элемента в середину связанного списка
     */
    public void add(int value, Node node) {
        // ссылка на что ссылается текущая нода в данный момент
        Node next = node.next;
        // создадим новую ноду
        Node newNode = new Node();
        // заполним ее значением
        newNode.value = value;
        // берем текущую ноду, ее текущее значение это новая нода
        node.next = newNode;
        // для новой ноды ее предыдущее значение это на текущий момент нода.
        newNode.previous = node;
        // следующее значение, обновляем tail потому что мы получили новую ноду
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    /**
     * @param value добавляемый элемент
     * @apiNote Операция вставки элемента в конец списка
     */
    public void add(int value) {
        // создадим новую ноду
        Node node = new Node();
        // заполним ее значением
        node.value = value;
        // определим есть ли какие-то элементы в нашем списке или это первая нода
        // если head равен null, тогда head становится текущей нодой, и tail становиться текущей нодой
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // иначе текущий tail равен нашей ноде
            tail.next = node;
            // наша нода начинает ссылаться на текущий tail
            node.previous = tail;
            // tail обновляем значением нашей ноды
            tail = node;
            // мы добавили элемент в конец связанного списка
        }
    }

    /**
     * @param node удаляемая нода
     * @apiNote Операция удаления ноды из связанного списка
     */
    public void delete(Node node) {
        // укажем наши новые переменные, предыдущую и следующую
        Node previous = node.previous;
        Node next = node.next;
        // если мы получили head ноду
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            // если мы получили tail ноду
            if (next == null) {
                previous.next = null;
                next.previous = previous;

                // если ни то, ни другое не выполняется, то
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    /**
     * @apiNote Разворот двусвязного списка
     */
    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    /**
     * @param value передаваемое значение
     * @apiNote Метод добавляет элемент в начало очереди
     */
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    /**
     * @apiNote Метод извлекает и удаляет последний элемент очереди
     * FIFO
     * @return значение элемента
     */
    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }
}
