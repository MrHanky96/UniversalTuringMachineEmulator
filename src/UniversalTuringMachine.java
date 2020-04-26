import java.util.List;

public class UniversalTuringMachine {
    private Tape memoryTape;                        //c) das Band mit 15 Elementen vor und nach dem Lese-/Schreibkopf,
                                                    //d) die aktuelle Position des Lese-/Schreibkopfes und
    private List<StateTransition> stateTransition;
    private State currentState;                     //b) die Angabe des aktuellen Zustandes der TM
    private int result;                             //a) das korrekte Ergebnis
    private int calculationStepCount;               //e) ein Zähler, der die Anzahl der bisher durchgeführten Berechnungsschritte angibt.

    public UniversalTuringMachine(List<StateTransition> stateTransition) {
        this.stateTransition = stateTransition;
        this.memoryTape = new Tape();
    }

    /*TODO: implentation of run:
        Akkzeptierender Zustand ist 2, Start Zustand ist 1
    * */
    public void run(String input) {

    }

    public Tape getMemoryTape() {
        return memoryTape;
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getResult() {
        return result;
    }

    public int getCalculationStepCount() {
        return calculationStepCount;
    }
}
