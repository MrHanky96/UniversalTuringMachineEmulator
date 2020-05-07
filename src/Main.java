import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter turing machine in binary form: ");
        List<StateTransition> stateTransitions = new ArrayList<>();
        boolean isTuringMachineInputValid = false;
        boolean isInputProvided = false;
        String input = "";

        while (!isTuringMachineInputValid) {
            try {
                String turingMachineBinaryRepresentation = scanner.nextLine();
                isInputProvided = turingMachineBinaryRepresentation.contains("111");

                if (isInputProvided) {
                    String[] turingMachineAndInput = turingMachineBinaryRepresentation.split("111");
                    turingMachineBinaryRepresentation = turingMachineAndInput[0];
                    input = turingMachineAndInput[1];
                }

                stateTransitions = decodeBinaryInputToSingleCommands(turingMachineBinaryRepresentation);
                isTuringMachineInputValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n Please try again: ");
            }
        }

        System.out.println("Single step mode?: (true/false)");
        boolean isSingleStepMode = scanner.nextBoolean();
        scanner.nextLine();

        if (!isInputProvided) {
            System.out.println("Enter your input for the turing machine: ");
            input = scanner.nextLine();
        }

        UniversalTuringMachine turingMachine = new UniversalTuringMachine(stateTransitions, isSingleStepMode);
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