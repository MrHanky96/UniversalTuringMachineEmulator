import java.util.List;
import java.util.Optional;

public class UniversalTuringMachine {
    private Tape memoryTape;
    private List<StateTransition> stateTransitions;
    private int currentState;
    private int calculationStepCount;
    private boolean isSingleStepMode;

    public UniversalTuringMachine(List<StateTransition> stateTransitions, boolean isSingleStepMode) {
        currentState = 1;
        this.stateTransitions = stateTransitions;
        this.memoryTape = new Tape();
        this.isSingleStepMode = isSingleStepMode;
    }

    public void run(String input) {
        if (!input.matches("[0-1]+")) {
            input = encodeInput(input);
        }

        int i = 0;
        char[] characters = input.toCharArray();
        StateTransition currentStateTransition = getCurrentStateTransition(characters[i]);

        while (currentStateTransition != null) {

            memoryTape.setCurrent(String.valueOf(characters[i]));

            if (currentStateTransition.getMemoryMovementDirection() == MemoryMovementDirection.LEFT) {
                memoryTape.moveLeft();
            } else {
                memoryTape.moveRight();
            }

            currentState = currentStateTransition.getFinalState();
            calculationStepCount++;

            if (isSingleStepMode) {
                print();
            }

            i++;
            char nextCharacter = characters.length > i ? characters[i] : '$';
            currentStateTransition = getCurrentStateTransition(nextCharacter);
        }

        if (!isSingleStepMode) {
            print();
        }
    }

    private void print() {
        if (currentState == 2) {
            System.out.println("A) Result: " + memoryTape.getBand());
        }

        System.out.println("B) Current state: " + currentState);
        System.out.println("C) Tape (15 signs each side): " + memoryTape.toString());
        System.out.println("D) Tape current state: " + memoryTape.getCurrent());
        System.out.println("E) Calculation step count: " + calculationStepCount + "\n");
    }

    private StateTransition getCurrentStateTransition(char inputCharacter) {
        Optional<StateTransition> stateTransition =  stateTransitions.stream().filter(transition ->
                transition.getInitialState() == currentState &&
                transition.getReceivedNumber().equals(String.valueOf(inputCharacter))
        ).findFirst();

        return stateTransition.isPresent() ? stateTransition.get() : null;
    }

    private String encodeInput(String input) {
        String[] numbers;

        if (input.contains("x")) {
            numbers = input.split("x");
        } else {
            numbers = input.split("[*]");
        }

        return getNumberAsZeros(Integer.parseInt(numbers[0])) + "1" + getNumberAsZeros(Integer.parseInt(numbers[1]));
    }

    private String getNumberAsZeros(int number) {
        return "0".repeat(Math.max(0, number));
    }
}
