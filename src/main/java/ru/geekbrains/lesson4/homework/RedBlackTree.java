package ru.geekbrains.lesson4.homework;

/**
 * Левостороннее красно-черное дерево.
 * Имеет следующие критерии:
 *
 * Каждая нода имеет цвет (красный или черный), и имеет двух потомков.
 * Корень дерева всегда черный
 * Новая нода всегда красная
 * Красные ноды могут быть только левым ребенком
 * У красной ноды все дети черного цвета
 */
public class RedBlackTree {
    /**
     * Реализовать:
     * Метод добавления новых элементов.
     * Балансировка:
     * 1. левый малый поворот
     * 2. правый малый поворот
     * 3. смена цвета
     */

    private Node root;

    /**
     * @apiNote Каркас дерева
     */
    private class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    /**
     * @apiNote Цвет узла дерева
     */
    private enum Color {
        RED, BLACK
    }

    /**
     * @apiNote Метод обработки рутовой ноды
     * @param value значение
     * @return boolean
     */
    public boolean add(int value) {
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    /**
     * @apiNote Метод добавления новой ноды, с использованием рекурсивных вызовов, обход в глубину
     * @param node добавляемая нода
     * @param value входное значение
     * @return boolean
     */
    public boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    /**
     * @apiNote Операция балансировки, имеет три операции
     * левый поворот
     * правый поворот
     * смена цвета
     * @param node нода
     * @return нода
     */
    public Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    /**
     * @apiNote Метод правостороннего перевода при операции балансировки
     * @param node нода поданная на вход
     * @return правый ребенок
     */
    public Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    /**
     * @apiNote Метод левостороннего перевода при операции балансировки
     * @param node нода поданная на вход
     * @return левый ребенок
     */
    public Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    /**
     * @apiNote Метод делает смену цвета для указанной ноды при операции балансировки
     * @param node нода
     */
    private void colorSwap(Node node) {
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }
}
