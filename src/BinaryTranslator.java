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

    private static State translateState(String state) throws Exception {
        switch (state) {
            case "0":
                return State.Q1;
            case "00":
                return State.Q2;
            case "000":
                return State.Q3;
            case "0000":
                return State.Q4;
            case "00000":
                return State.Q5;
            case "000000":
                return State.Q6;
            default:
                throw new Exception("State not found");
        }
    }

    private static int translateNumber(String number) throws Exception {
        switch (number) {
            case "0":
                return 0;
            case "00":
                return 1;
            case "000":
                return 2;
            case "0000":
                return 3;
            case "00000":
                return 4;
            case "000000":
                return 5;
            case "0000000":
                return 6;
            case "00000000":
                return 7;
            case "000000000":
                return 8;
            case "0000000000":
                return 9;
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
