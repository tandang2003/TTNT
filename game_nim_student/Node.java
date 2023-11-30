package game_nim_student;

import java.util.*;

public class Node {
    private List<Integer> data = new ArrayList<Integer>();

    public void add(Integer val) {
        this.data.add(val);
    }

    public void addAll(List<Integer> data) {
        this.data.addAll(data);
    }

    // Get children of the current nodes
    public List<Node> getSuccessors() {
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > 2) {
                for (int j = 1; j <= data.get(i) / 2; j++) {
                    if (data.get(i) - j != j) {
                        Node nNode = new Node();
                        nNode.addAll(data);
                        nNode.data.remove(i);
                        nNode.data.add(i, data.get(i) - j);
                        nNode.data.add(i, j);
                        Collections.sort(nNode.data,DESCOMPARATOR);
                        if (!result.contains(nNode)) result.add(nNode);
                    } else {
                        break;
                    }
                }
            } else if (data.get(i) == 1 || data.get(i) == 2) {
                break;
            }
        }
        return result;
    }

    // Check whether a node is terminal or not
    public boolean isTerminal() {
        return data.get(0) < 2;
    }

    public List<Integer> getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    @Override
    public String toString() {
        Collections.sort(this.data, DESCOMPARATOR);
        return this.data.toString();
    }

}
