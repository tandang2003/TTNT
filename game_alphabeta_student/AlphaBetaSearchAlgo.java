package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {
//in ra node bij catws
	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		node.setValue(maxValue(node,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) return node.getValue();
		int v= Integer.MIN_VALUE;
		boolean flag=false;
		for(Node n: node.getChildren()){
			v=Math.max(v, minValue(n,alpha,beta));
			if(v>=beta) {
				if(flag){System.out.println(n.toString());}else
				flag=true;

			}
			else
			alpha=Math.max(v, alpha);
		}
		node.setValue(v);
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if(node.isTerminal()) return node.getValue();
		boolean flag=false;
		int v= Integer.MAX_VALUE;
		for(Node n: node.getChildren()){
			v=Math.min(v, maxValue(n,alpha,beta));
			if(v<=alpha){
				if(flag){System.out.println(n.toString());}else
					flag=true;

			}else
			beta=Math.min(v, beta);
		}
		node.setValue(v);
		return v;
	}
}
