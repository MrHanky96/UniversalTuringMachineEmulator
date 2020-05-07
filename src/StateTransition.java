public class StateTransition {
    private int initialState;
    private int finalState;
    private int receivedNumber;
    private int returnNumber;
    private MemoryMovementDirection memoryMovementDirection;

    public StateTransition(int initialState, int finalState,
                           int receivedNumber, int returnNumber,
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

    public int getReceivedNumber() {
        return receivedNumber;
    }

    public MemoryMovementDirection getMemoryMovementDirection() {
        return memoryMovementDirection;
    }
}
