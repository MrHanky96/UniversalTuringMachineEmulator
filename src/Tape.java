import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tape {
    private char current;
    private final char EMPTY = '$';
    private final int TAPE_OUTPUT_LIMITER = 15;
    private Stack<Character> right = new Stack();
    private Stack<Character> left = new Stack();

    public void right() {
        left
    }

    public void left() {

    }

    @Override
    public String toString() {
        ArrayList<String> rightSideLimited = new ArrayList<>();
        ArrayList<String> leftSideLimited = new ArrayList<>();
        for (int i = 0; i < TAPE_OUTPUT_LIMITER; i++) {
            rightSideLimited.add();
        }

        return "Left side: " + String.join(", ", rightSideLimited) +
                "Current: " + current +
                "Right side: " + String.join(", ", leftSideLimited);
    }
}
