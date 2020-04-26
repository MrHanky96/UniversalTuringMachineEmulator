import java.util.Stack;

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

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    @Override
    public String toString() {

        for (int i = 0; i < TAPE_OUTPUT_LIMITER; i++) {

        }

        return "Left side: ... " +
                String.join(", ", right.subList(right.size(), right.size() - TAPE_OUTPUT_LIMITER)) +
                "Current: " + current +
                "Right side: " +
                String.join(", ", left.subList(left.size(), left.size() - TAPE_OUTPUT_LIMITER)) +
                " ...";
    }
}
