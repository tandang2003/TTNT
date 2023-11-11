package student;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class HillClimbingSearch {
    private Node node;

    public HillClimbingSearch() {
        this.node = new Node();
        this.node.generateBoard();
    }


    public Node getNode() {
        return node;
    }

    public Node execute(Node initialState) {
        Node curr = initialState;
        Node neighbor = null;
        while (true) {
            if(curr.getH()==0) return curr;
            neighbor = curr.getBestGenerate();
            if (neighbor.getH() < curr.getH()) curr = neighbor ;
            else curr.generateBoard();
        }


    }

    public Node executeHillClimbingWithRandomRestart(Node
                                                             initialState) {
// Enter your code here.
        return null;
    }


}
