package chapter2.agent_ABCD;

public class DynamicAction extends Action {
	private String name;

	public DynamicAction(String name) {
		this.name = name;
	}

	@Override
	public boolean isNoOp() {
		return false;
	}
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DynamicAction){
			DynamicAction dy=(DynamicAction) obj;
			return dy.name.equals(name);
		}
		return false;
	}
}

