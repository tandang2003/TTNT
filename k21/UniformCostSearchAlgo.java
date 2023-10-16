package k21;

import java.util.*;

public class UniformCostSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return (int) (node1.getPathCost() - node2.getPathCost());
            }
        });
        frontier.offer(root);
        List<Node> explorer = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node chosen = frontier.poll();
            if (chosen.getLabel().equals(goal)) {
                return chosen;
            }
            explorer.add(chosen);
            for (Edge edge : chosen.getChildren()) {
                Node child = edge.getEnd();
                if (!explorer.contains(child) && !frontier.contains(child)) {
                    child.setParent(chosen);
                    child.setPathCost(chosen.getPathCost() + edge.getWeight());
                    frontier.offer(child);
                } else if (child.getPathCost() > chosen.getPathCost() + edge.getWeight()) {
                    child.setParent(chosen);
                    child.setPathCost(chosen.getPathCost() + edge.getWeight());
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return (int) (node1.getPathCost() - node2.getPathCost());
            }
        });
        boolean flag = false;
        frontier.offer(root);
        List<Node> explorer = new ArrayList<>();
        while (!frontier.isEmpty()) {
            Node chosen = frontier.poll();
            if (chosen.getLabel().equals(goal) && flag) {
                return chosen;
            }
            if (chosen.getLabel().equals(start)) {
                frontier.clear();
                flag = true;
            }
            explorer.add(chosen);
            for (Edge edge : chosen.getChildren()) {
                Node child = edge.getEnd();
                if (!explorer.contains(child) && !frontier.contains(child)) {
                    if(flag) {
                        child.setPathCost(chosen.getPathCost() + edge.getWeight());
                        child.setParent(chosen);
                    }frontier.offer(child);
                } else if (child.getPathCost() > chosen.getPathCost() + edge.getWeight()) {
                    child.setParent(chosen);
                    child.setPathCost(chosen.getPathCost() + edge.getWeight());
                }
            }
        }
        return null;
    }
}
