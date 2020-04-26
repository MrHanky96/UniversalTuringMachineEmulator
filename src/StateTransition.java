import javafx.beans.property.StringProperty;

public class StateTransition {
    private State initialState;
    private State finalState;
    private int receivedNumber;
    private int returnNumber;
    private String memoryMovementDirection;

    public StateTransition(State initialState, State finalState,
                           int receivedNumber, int returnNumber,
                           String memoryMovementDirection) {
        this.initialState = initialState;
        this.finalState = finalState;
        this.receivedNumber = receivedNumber;
        this.returnNumber = returnNumber;
        this.memoryMovementDirection = memoryMovementDirection;
    }

    @Override
    public String toString() {
        return String.format("(%1$s, %2$s) = (%3$s, %4$s, %5$s)",
                initialState, receivedNumber,
                finalState, returnNumber,
                memoryMovementDirection
        );
    }
}
