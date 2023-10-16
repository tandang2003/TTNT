package k21;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>,Cloneable {
	private String label;
	private Node parent; // for printing the path from the start node to goal node
	private double pathCost;// from the root node to this node
	private int depth;// used for compute the depth of a node in a tree search
	private List<Edge> children = new ArrayList<Edge>();

	public Node(String label) {
		this.label = label;
	}

	public Node(String label, int h) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Edge> getChildren() {
		return children;
	}

	public List<Node> getChildrenNodes() {
		List<Node> result = new ArrayList<Node>();
		for (Edge edge : this.children) {
			result.add(edge.getEnd());
		}
		return result;
	}
	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that, double cost) {
		Edge edge = new Edge(this, that, cost);
		for (int i = 0; i < children.size(); i++) {
			if(edge.compareTo(children.get(i))>0){
				children.add(i,edge);
				return;
			}
		}
		this.children.add(edge);
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that) {
		Edge edge = new Edge(this, that);
		for (int i = 0; i < children.size(); i++) {
			if(edge.compareTo(children.get(i))>0){
				children.add(i,edge);
				return;
			}
		}
		this.children.add(edge);
	}
	public Edge getEdge(Node that){
		for (Edge edge: children) {
			if (edge.getEnd().equals(that)){
				return edge;
			}
		}
		return null;
	}
	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.label + "_"  + this.pathCost;
	}

	@Override
	public int compareTo(Node o) {
		return this.label.compareTo(o.label);
	}
	public Node clonable(Node parent) {
		Node result = new Node(label);
		result.depth=depth;
		result.children=children;
		result.parent=parent;
		result.pathCost=parent.getPathCost()+parent.getEdge(result).getWeight();
		return result;
	}

}
