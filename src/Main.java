import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter turing machine in binary form: ");
        List<StateTransition> stateTransitions = new ArrayList<>();
        boolean isTuringMachineInputValid = false;

        while (!isTuringMachineInputValid) {
            try {
                String turingMachineBinaryRepresentation = scanner.nextLine();
                stateTransitions = decodeBinaryInputToSingleCommands(turingMachineBinaryRepresentation);
                isTuringMachineInputValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n Please try again: ");
            }
        }

        System.out.println("Single step mode?: (true/false)");
        boolean isSingleStepMode = scanner.nextBoolean();

        UniversalTuringMachine turingMachine = new UniversalTuringMachine(stateTransitions, isSingleStepMode);

        System.out.println("Enter your input for the turing machine: ");
        String input = scanner.nextLine();

        turingMachine.run(input);
    }

    private static List<StateTransition> decodeBinaryInputToSingleCommands(String turingMachineBinaryRepresentation) throws Exception {
        List<StateTransition> stateTransitions = new ArrayList<>();
        String[] transitionsInBinary = turingMachineBinaryRepresentation.split("11");

        for (String transitionInBinary : transitionsInBinary) {
            String[] singleSymbolsInBinary = transitionInBinary.split("1");

            stateTransitions.add(BinaryTranslator.translate(
                singleSymbolsInBinary[0],
                singleSymbolsInBinary[1],
                singleSymbolsInBinary[2],
                singleSymbolsInBinary[3],
                singleSymbolsInBinary[4]
            ));
        }

        return stateTransitions;
    }
}