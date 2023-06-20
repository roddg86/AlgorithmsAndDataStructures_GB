package ru.geekbrains.lesson4.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @apiNote Обход дерева в ширину, лекция 13:20
 */
public class TreeWidth {

    private Node root;

    public class Node {
        int value;
        List<Node> children;
    }

    /**
     * @param value значение
     * @return ноду
     * @apiNote функция поиска, обхода в ширину
     */
    private Node find(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if(node.value == value){
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }
}
