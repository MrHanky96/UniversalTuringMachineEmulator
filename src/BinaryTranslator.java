public class BinaryTranslator {
    public static StateTransition translate(String initialState, String finalState,
                                            String receivedNumber, String returnNumber,
                                            String memoryMovementDirection) {

        return new StateTransition(
                translateState(initialState),
                translateState(finalState),
                translateNumber(receivedNumber),
                translateNumber(returnNumber),
                translateMemoryMovementDirection(memoryMovementDirection));
    }

    private static State translateState(String initialState) {
    }

    private static int translateNumber(String receivedNumber) {
    }

    private static String translateMemoryMovementDirection(String memoryMovementDirection) {
    }
}
