public class BinaryTranslator {
    public static StateTransition translate(String initialState, String receivedNumber,
                                            String finalState, String returnNumber,
                                            String memoryMovementDirection) throws Exception {
        return new StateTransition(
                translateState(initialState),
                translateState(finalState),
                translateNumber(receivedNumber),
                translateNumber(returnNumber),
                translateMemoryMovementDirection(memoryMovementDirection));
    }

    private static int translateState(String state) {
        return state.length();
    }

    private static int translateNumber(String number) throws Exception {
        switch (number) {
            case "0":
                return 0;
            case "00":
                return 1;
            default:
                throw new Exception("Number not found: " + number);
        }
    }

    private static MemoryMovementDirection translateMemoryMovementDirection(String memoryMovementDirection) throws Exception {
        switch (memoryMovementDirection) {
            case "0":
                return MemoryMovementDirection.LEFT;
            case "00":
                return MemoryMovementDirection.RIGHT;
            default:
                throw new Exception("Movement not found: " + memoryMovementDirection);
        }
    }
}
