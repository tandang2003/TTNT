package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {


    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<Node>();
        Node goalNode = new Node(goal);
        frontier.add(root);
        List<Node> explorer = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node chooseNode = frontier.poll();
            explorer.add(chooseNode);
            if (chooseNode.equals(goalNode)) {
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
        Queue<Node> frontier = new LinkedList<Node>();
        frontier.add(root);
        Node startNode = new Node(start);
        boolean flag = false;
        List<Node> explorer = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node chooseNode = frontier.poll();
            explorer.add(chooseNode);
            if (chooseNode.getLabel().equals(start)) {
                frontier.clear();
                explorer.clear();
                flag = true;
            }
            if (chooseNode.getLabel().equals(goal) && flag) {
                return chooseNode;
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
