package k21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeBreadthFirstSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node choosenNode = frontier.poll();
            if (choosenNode.getLabel().equals(goal))
                return choosenNode;
            for (Node node : choosenNode.getChildrenNodes()) {
                frontier.add(node.clonable(choosenNode));
            }

        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root);
        boolean flag = false;
        while (!frontier.isEmpty()) {
            Node choosenNode = frontier.poll();
            if (choosenNode.getLabel().equals(goal) && flag)
                return choosenNode;
            if (choosenNode.getLabel().equals(start)) {
                frontier.clear();
                flag = true;
            }
            for (Node node : choosenNode.getChildrenNodes()) {
                if (flag) {
                    frontier.add(node.clonable(choosenNode));
                } else {
                    frontier.add(node);
                }

            }

        }
        return null;
    }
}
