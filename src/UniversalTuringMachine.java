import java.util.List;
import java.util.Optional;

public class UniversalTuringMachine {
    private Tape memoryTape;                        //c) das Band mit 15 Elementen vor und nach dem Lese-/Schreibkopf,
                                                    //d) die aktuelle Position des Lese-/Schreibkopfes und
    private List<StateTransition> stateTransition;
    private int currentState;                     //b) die Angabe des aktuellen Zustandes der TM
    private int calculationStepCount;               //e) ein Zähler, der die Anzahl der bisher durchgeführten Berechnungsschritte angibt.
    private boolean isSingleStepMode;

    public UniversalTuringMachine(List<StateTransition> stateTransition, boolean isSingleStepMode) {
        currentState = 1;
        this.stateTransition = stateTransition;
        this.memoryTape = new Tape();
        this.isSingleStepMode = isSingleStepMode;
    }

    public void run(String input) {
        if (!input.matches("[0-1]+")) {
            input = encodeInput(input);
        }

        char[] characters = input.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            StateTransition currentStateTransition = getCurrentStateTransition(characters[i]).get();

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
        }

        if (!isSingleStepMode) {
            print();
        }
    }

    private void print() {
        System.out.println("A) Result: " + memoryTape.toString());
        System.out.println("B) Current state: " + currentState);
        System.out.println("C) Tape (15 signs each side): " + memoryTape.toString());
        System.out.println("D) Tape current state: " + memoryTape.getCurrent());
        System.out.println("E) Calculation step count: " + calculationStepCount);
    }

    private Optional<StateTransition> getCurrentStateTransition(char inputCharacter) {
        return stateTransition.stream().filter(transition ->
                transition.getInitialState() == currentState &&
                transition.getReceivedNumber() == inputCharacter
        ).findFirst();
    }

    private String encodeInput(String input) {
        String[] numbers;

        if (input.contains("x")) {
            numbers = input.split("x");
        } else {
            numbers = input.split("[*]");
        }

        return getNumberAsZeros(Integer.parseInt(numbers[0])) + "111" + getNumberAsZeros(Integer.parseInt(numbers[1]));
    }

    private String getNumberAsZeros(int number) {
        String zeros = "0";

        for (int i = 0; i < number; i++) {
            zeros += "0";
        }

        return zeros;
    }
}
