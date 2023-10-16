package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch {
    public Node execute(Node root, String goal, int limitedDepth) {

        return iterativeDSL(root, goal, limitedDepth);
    }

    private Node recusiveDSL(Node root, String goal, int limitedDepth) {
        Node result = null;
        if (root.getLabel().equals(goal)) {
            return root;
        } else if (limitedDepth == 0) {
            return null;
        } else {
            for (Node node : root.getChildrenNodes()) {
                if (result == null) {
                    Node child = node.clonable(root);
                    result = recusiveDSL(child, goal, limitedDepth - 1);
                }
            }
        }
        return result;
    }

    private Node iterativeDSL(Node root, String goal, int limitedDepth) {
        Stack<Node> frontier;
        root.setDepth(0);
        List<Node> explorer;
        for (int i = 0; i <= limitedDepth; i++) {
            frontier = new Stack<>();
            frontier.add(root);
            explorer = new ArrayList<>();
            while (!frontier.isEmpty()) {
                Node chosen = frontier.pop();
                    if (chosen.getLabel().equals(goal)) {
                        return chosen;
                    }
                    if (chosen.getDepth() < i) {
                    for (Node child : chosen.getChildrenNodes()) {
                        if (!frontier.contains(child) && !explorer.contains(child)) {
                            child.setDepth(chosen.getDepth() + 1);
                            child.setParent(chosen);
                            child.setPathCost(chosen.getPathCost() + chosen.getEdge(child).getWeight());
                            frontier.add(child);
                        }
                    }
                }
            }
        }
        return null;
    }

}
