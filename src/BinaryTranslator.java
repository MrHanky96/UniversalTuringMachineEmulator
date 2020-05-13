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

    private static String translateNumber(String number) {
        switch (number) {
            case "0":
                return "0";
            case "00":
                return "1";
            case "000":
                return Tape.EMPTY;
            case "0000":
                return "A";
            case "00000":
                return "B";
            case "000000":
                return "C";
            default:
                return "";
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
