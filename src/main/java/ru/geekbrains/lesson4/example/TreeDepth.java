package ru.geekbrains.lesson4.example;

import java.util.List;

/**
 * @apiNote Обход дерева в глубину, лекция 11:50
 */
public class TreeDepth {
    private Node root;

    /**
     * @param node  входная нода
     * @param value значенмие
     * @return ноду
     * @apiNote Функция поиска ноды
     */
    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else { // проверим детей, уйдем в глубину
            for (Node child : node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * @param value значение
     * @return boolean
     * @apiNote Функция отображает получиться ли у нас найти ноду и вернуть ее значение или нет.
     */
    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    public class Node {
        int value;
        List<Node> children;
    }
}
