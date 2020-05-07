import java.util.Stack;
import java.util.stream.Collectors;

public class Tape {
    private String current;
    private final String EMPTY = "$";
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
        return left.stream().collect(Collectors.joining()) + right.stream().collect(Collectors.joining());
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Left side: ... " +
                String.join(", ", right.toString()) +
                "Current: " + current +
                "Right side: " +
                String.join(", ", left.toString()) +
                " ...";
    }
}
