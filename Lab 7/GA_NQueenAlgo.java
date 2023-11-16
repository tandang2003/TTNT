package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
    public static final int POP_SIZE = 100;//Population size
    public static final double MUTATION_RATE = 0.03;
    public static final int MAX_ITERATIONS = 1000;
    public static final int K = 10;
    List<Node> population = new ArrayList<Node>();
    Random rd = new Random();

    // initialize the individuals of the population
    public void initPopulation() {
        for (int i = 0; i < POP_SIZE; i++) {
            Node ni = new Node();
            ni.generateBoard();
            population.add(ni);
        }
    }

    public Node execute() {
        int iteration = 0; initPopulation();
        Node result = new Node();
        while (iteration < MAX_ITERATIONS) {
            Random rd = new Random();
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < population.size(); i++) {
                Node x = getParentByRandomSelection();
                Node y = getParentByRandomSelection();
                Node child = reproduce(x, y);
                if (rd.nextInt() < MUTATION_RATE) mutate(child);
                if (child.getH()==0) return child;
                nodes.add(child);
            }
            population = nodes;
            iteration++;

        }
        Collections.sort(population);
        return population.get(0);
    }

    // Mutate an individual by selecting a random Queen and
//move it to a random row.
    public void mutate(Node node) {
        Random rd = new Random();
        int index = rd.nextInt(node.getState().length);
        node.setRow(index, rd.nextInt(node.getState().length));
    }

    //Crossover x and y to reproduce a child
    public Node reproduce(Node x, Node y) {
        Node childNode = new Node();
        Random rd = new Random();
        int seperate = rd.nextInt(x.getState().length);
        for (int i = 0; i <= seperate; i++) {
            childNode.setRow(i, x.getRow(i));
        }
        for (int i = seperate + 1; i < y.getState().length; i++) {
            childNode.setRow(i, y.getRow(i));
        }

// Enter your code here
        return childNode;
    }

    // Select K individuals from the population at random and
//select the best out of these to become a parent.
    public Node getParentByTournamentSelection() {
        Random rd = new Random();
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            nodes.add(getParentByRandomSelection());
        }
        return nodes.get(rd.nextInt(K));
    }

    //Select a random parent from the population
    public Node getParentByRandomSelection() {
        Random rd = new Random();
        return population.get(rd.nextInt(population.size()));
    }
}

