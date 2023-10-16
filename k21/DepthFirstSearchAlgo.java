package k21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<Node>();
        frontier.add(root);
        List<Node> explorer = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node chooseNode = frontier.pop();
            explorer.add(chooseNode);
            if (chooseNode.getLabel().equals(goal)) {
                return chooseNode;
            }
            for (Node node : chooseNode.getChildrenNodes()) {
                if (!frontier.contains(node) && !explorer.contains(node)) {
                    node.setParent(chooseNode);
                    node.setPathCost(chooseNode.getPathCost() + chooseNode.getEdge(node).getWeight());
                    frontier.add(node);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Stack<Node> frontier = new Stack<Node>();
        frontier.add(root);
        boolean flag = false;
        List<Node> explorer = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node chooseNode = frontier.pop();
            explorer.add(chooseNode);
            if (chooseNode.getLabel().equals(goal) && flag) {
                return chooseNode;
            }
            if (chooseNode.getLabel().equals(start)) {
                frontier.clear();
                explorer.clear();
                flag = true;
            }
            for (Node node : chooseNode.getChildrenNodes()) {
                if (!frontier.contains(node) && !explorer.contains(node)) {
                    if (flag) {
                        node.setParent(chooseNode);
                        node.setPathCost(chooseNode.getPathCost() + chooseNode.getEdge(node).getWeight());
                    }
                    frontier.add(node);
                }
            }
        }
        return null;
    }
}
