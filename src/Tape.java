import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class Tape {
    private String current;
    public static final String EMPTY = "$";
    private final int TAPE_OUTPUT_LIMITER = 15;
    private Stack<String> right = new Stack();
    private Stack<String> left = new Stack();

    public Tape() {
        right.push(EMPTY);
        current = right.pop();
    }

    public void moveLeft() {
        right.push(current);

        if (left.isEmpty()) {
            left.push(EMPTY);
        }

        current = left.pop();
    }

    public void moveRight() {
        left.push(current);

        if (right.isEmpty()) {
            right.push(EMPTY);
        }

        current = right.pop();
    }

    public String getBand() {
        return left.stream().collect(Collectors.joining()) + current + right.stream().collect(Collectors.joining());
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    @Override
    public String toString() {
        ArrayList<String> rightLimited = new ArrayList<>();
        rightLimited.addAll(right);

        while (rightLimited.size() <= TAPE_OUTPUT_LIMITER) {
            rightLimited.add(EMPTY);
        }

        ArrayList<String> leftLimited = new ArrayList<>();
        leftLimited.addAll(left);

        while (leftLimited.size() <= TAPE_OUTPUT_LIMITER) {
            leftLimited.add(0, EMPTY);
        }

        return String.join(", ",
                leftLimited.subList(
                    leftLimited.size() - TAPE_OUTPUT_LIMITER, leftLimited.size()
            )
        ) + ", [" + current + "], " +  String.join(", ", rightLimited.subList(0, TAPE_OUTPUT_LIMITER));
    }
}
