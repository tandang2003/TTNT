package chapter2.agent_ABCD;

public class Environment {
    public static final Action MOVE_LEFT = new DynamicAction("LEFT");
    public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
    public static final Action MOVE_UP = new DynamicAction("UP");
    public static final Action MOVE_DOWN = new DynamicAction("DOWN");
    public static final Action SUCK_DIRT = new DynamicAction("SUCK");
    public static final String LOCATION_A = "A";
    public static final String LOCATION_B = "B";
    public static final String LOCATION_C = "C";
    public static final String LOCATION_D = "D";

    public enum LocationState {
        CLEAN, DIRTY
    }

    private EnvironmentState envState;
    private boolean isDone = false;// all squares are CLEAN
    private Agent agent = null;

    public Environment(LocationState locAState, LocationState locBState, LocationState locCState, LocationState locDState) {
        envState = new EnvironmentState(locAState, locBState, locCState, locDState);
    }

    // add an agent into the enviroment
    public void addAgent(Agent agent, String location) {
        this.agent = agent;
        this.envState.setAgentLocation(location);
    }

    public EnvironmentState getCurrentState() {
        return this.envState;
    }

    // Update enviroment state when agent do an action
    public EnvironmentState executeAction(Action action) {
        if (action.equals(MOVE_LEFT)) {
            if (envState.getAgentLocation() == LOCATION_B) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_A);
            } else if (envState.getAgentLocation() == LOCATION_C) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_D);
            } else {
                agent.wrongAction();
            }
        } else if (action.equals(MOVE_RIGHT)) {
            if (envState.getAgentLocation() == LOCATION_A) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_B);
            } else if (envState.getAgentLocation() == LOCATION_D) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_C);
            } else {
                agent.wrongAction();
            }
        } else if (action.equals(MOVE_UP)) {
            if (envState.getAgentLocation() == LOCATION_C) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_B);
            } else if (envState.getAgentLocation() == LOCATION_D) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_A);
            } else {
                agent.wrongAction();
            }
        } else if (action.equals(MOVE_DOWN)) {
            if (envState.getAgentLocation() == LOCATION_A) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_D);
            } else if (envState.getAgentLocation() == LOCATION_B) {
                agent.eachAction();
                envState.setAgentLocation(LOCATION_C);
            } else {
                agent.wrongAction();
            }
        } else if (action.equals(SUCK_DIRT)) {
            agent.suckSuccess();
            envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
        }
        return envState;
    }


    // get percept<AgentLocation, LocationState> at the current location where agent
    // is in.
    public Percept getPerceptSeenBy() {
        return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
    }

    public void step() {
        envState.display();
        String agentLocation = this.envState.getAgentLocation();
        Action anAction = agent.execute(getPerceptSeenBy());
        EnvironmentState es = executeAction(anAction);

        System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
        System.out.println("Agent's Score: " +agent.getScore());
        if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
                && (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
                && (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
                && (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
            isDone = true;// if both squares are clean, then agent do not need to do any action
        es.display();
    }

    public void step(int n) {
        for (int i = 0; i < n; i++) {
            step();
            System.out.println("-------------------------");
        }
    }

    public void stepUntilDone() {
        int i = 0;

        while (!isDone) {
            System.out.println("step: " + i++);
            step();
        }
    }
}
