package chapter2.agent_ABCD;

public abstract class Action {
	public abstract boolean isNoOp();

	@Override
	public abstract boolean equals(Object obj);
}