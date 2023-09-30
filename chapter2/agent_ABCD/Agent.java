package chapter2.agent_ABCD;

public class Agent {
	private AgentProgram program;
private int score;
	public Agent() {
		score=0;
	}

	public Agent(AgentProgram aProgram) {
		program = aProgram;
	}

	public Action execute(Percept p) {
		if (program != null) {
			return program.execute(p);
		}
		return NoOpAction.NO_OP;
	}
public int eachAction(){
		return score-=10;
}
public int wrongAction(){
		return score-=100;
}
public int suckSuccess(){
		return score+=500;
}

	public int getScore() {
		return score;
	}
}
