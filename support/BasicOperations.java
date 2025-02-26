import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BasicOperations {
    protected static Set<Integer> set = new HashSet<> ();
    protected static Random myRandom = new Random();
    protected static int maximum = Integer.MIN_VALUE;
    protected static int minimum = Integer.MAX_VALUE;
    protected static int numberOfElements = myRandom.nextInt(5, 12);

    protected static void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    protected static void displaysNewLine() {
        System.out.println();
    }

    protected static void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    protected static void displaysMessage(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        System.out.println(message);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    protected static void displaysMessage(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
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

    protected static void displaysMessage(String message) {
        System.out.print(message);
    }

    protected static int formsData(boolean isDataPresent) {
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

    protected static void formsData(int numberOfElements) {
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
