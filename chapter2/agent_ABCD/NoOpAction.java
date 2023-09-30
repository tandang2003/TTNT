package chapter2.agent_ABCD;

public class NoOpAction extends Action {
	public static final NoOpAction NO_OP = new NoOpAction();

	public boolean isNoOp() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof NoOpAction){
			return true;
		}
		return false;
	}


}