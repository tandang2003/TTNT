package chapter2.agent_ABCD;

import java.util.Random;

public class AgentProgram {

    public Action execute(Percept p) {// location, status
        if (p.getLocationState().equals(Environment.LocationState.DIRTY))
            return Environment.SUCK_DIRT;
        if (p.getLocationState().equals(Environment.LocationState.CLEAN))
            return makeDecision();
        return NoOpAction.NO_OP;
    }

    private Action makeDecision() {
        Random rd = new Random();
        int a = rd.nextInt(4);
        if (a == 3) return Environment.MOVE_UP;
        if (a == 2) return Environment.MOVE_DOWN;
        if (a == 1) return Environment.MOVE_RIGHT;
        else
            return Environment.MOVE_LEFT;
    }
}