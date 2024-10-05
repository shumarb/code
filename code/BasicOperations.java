import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class BasicOperations {
    protected Set<Integer> set = new HashSet<> ();
    protected Random myRandom = new Random();
    protected int maximum = Integer.MIN_VALUE;
    protected int minimum = Integer.MAX_VALUE;
    protected int numberOfElements;

    protected void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    protected void displaysNewLine() {
        System.out.println();
    }

    protected void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    protected void displaysMessage(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        System.out.println(message);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    protected void displaysMessage(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        if (messageType == 0) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    protected void displaysMessage(String message) {
        System.out.print(message);
    }

    protected int formsData(boolean isDataPresent) {
        int data;
        if (set.isEmpty()) {
            set = new HashSet<> ();
        }
        if (isDataPresent) {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    }

    protected void formsData(int numberOfElements) {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        if (set.isEmpty()) {
            set = new HashSet<> ();
        }
        int data = myRandom.nextInt(-100, 101);
        int order = myRandom.nextInt(1, 4);
        for (int i = 0; i < numberOfElements; i++) {
            if (order == 1) {
                set.add(data++);
            } else if (order == 2) {
                set.add(data--);
            } else {
                while (set.contains(data)) {
                    data = myRandom.nextInt(-100, 101);
                }
                set.add(data);
            }
        }
    }

}
