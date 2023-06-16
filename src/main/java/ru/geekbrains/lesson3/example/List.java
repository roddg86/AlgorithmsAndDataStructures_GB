package ru.geekbrains.lesson3.example;

public class List {

    // начало списка
    Node head;

    /**
     * @apiNote Базовая структура односвязного списка
     * value значение
     * next ссылка на следующую ноду
     */
    public class Node{
        int value;
        Node next;

    }

    /**
     * @apiNote Метод добавляет элемент в начало стека
     * @param value передаваемое значение
     */
    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    /**
     * @apiNote Метод удаления последнего элемента из стека
     * @return значение элемента
     */
    public Integer pop(){
        Integer result = null;
        if(head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }

    /**
     * @apiNote метод поиска элементов в односвязном списке, перебор всех доступных детей, O(n)
     * @param value искомый элемент
     * @return найденный элемент
     */
    public Node find(int value){
        Node currentNode = head; // текущая нода
        // пока текущая нода не равна null, если текущая нода равна искомому значению вернем текущую ноду
        while (currentNode != null){
            if(currentNode.value == value){
                return currentNode;
            }
            // если этого не произошло, обновляем текущую ноду, присвоив следующую ноду по списку
            currentNode = currentNode.next;
        }
        // если элемента не нашлось вернуть null
        return null;
    }

    /**
     * @apiNote функция которая просто запускает разворот
     */
    public void revert(){
        if (head != null && head.next != null){
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    /**
     * @apiNote Разворот односвязного списка, используем рекурсию
     * @param currentNode текущая нода
     * @param previousNode предыдущая нода
     */
    private void revert(Node currentNode, Node previousNode){
        if(currentNode.next == null){
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

}
