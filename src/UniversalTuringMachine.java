import java.util.List;

public class UniversalTuringMachine {
    private Tape memoryTape;
    private List<StateTransition> stateTransition;
    private State currentState;
    private int result;

    public UniversalTuringMachine(List<StateTransition> stateTransition) {
        this.stateTransition = stateTransition;
        this.memoryTape = new Tape();
    }

    public void run() {

    }


    public Tape getMemoryTape() {
        return memoryTape;
    }

    public void setMemoryTape(Tape memoryTape) {
        this.memoryTape = memoryTape;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
