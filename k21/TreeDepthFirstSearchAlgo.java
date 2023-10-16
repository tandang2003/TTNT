package k21;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeDepthFirstSearchAlgo implements ISearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node choosenNode = frontier.pop();
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
        Stack<Node> frontier = new Stack<>();
        frontier.add(root);
        boolean flag= false;
        while (!frontier.isEmpty()) {
            Node choosenNode = frontier.pop();
            if (choosenNode.getLabel().equals(goal)&&flag)
                return choosenNode;
            if(choosenNode.getLabel().equals(start)){
                flag=false;
            }
            for (Node node : choosenNode.getChildrenNodes()) {
                if (flag)
                frontier.add(node.clonable(choosenNode));
                else frontier.add(node);
            }

        }
        return null;
    }
}
