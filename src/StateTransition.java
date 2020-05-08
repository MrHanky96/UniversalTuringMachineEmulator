public class StateTransition {
    private int initialState;
    private int finalState;
    private String receivedNumber;
    private String returnNumber;
    private MemoryMovementDirection memoryMovementDirection;

    public StateTransition(int initialState, int finalState,
                           String receivedNumber, String returnNumber,
                           MemoryMovementDirection memoryMovementDirection) {
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

    public int getInitialState() {
        return initialState;
    }

    public int getFinalState() {
        return finalState;
    }

    public String getReceivedNumber() {
        return receivedNumber;
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public MemoryMovementDirection getMemoryMovementDirection() {
        return memoryMovementDirection;
    }
}
