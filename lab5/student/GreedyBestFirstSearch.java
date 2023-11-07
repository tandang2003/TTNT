package puzzle_8.student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static puzzle_8.student.Puzzle.operators;

public class  GreedyBestFirstSearch implements IPuzzleAlgo {
    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        List<Node> explored = new ArrayList<>();
        Node init = model.getInitialState();
        frontier.add(init);
        while (!frontier.isEmpty()) {
            Node chosen = frontier.poll();
            if (model.computeH2(chosen) == 0) return chosen;
            else {
                explored.add(chosen);
                List<Node> children= model.getSuccessors(chosen);
                for(Node child: children){
                    if(!frontier.contains(child)&& !explored.contains(child)){
                        frontier.add(child);
                    }
                }
            }
        }
        return null;
    }
}
