import java.util.Arrays;

class CountingSort extends BasicOperations {
    private static int n;
    private static int[] inputArray;
    private static int[] initialArray;
    private static int[] valueFrequency;

    private static void displaysChange() {
        displaysMessage(0, "======= Heap Sort =======", false, false);
        displaysMessage(" * Before:\t" + Arrays.toString(initialArray), true, false);
        displaysMessage(" * After:\t" + Arrays.toString(inputArray), false, true);
    }

    private static void insertion() {
        displaysLine();
        displaysMessage(0, "======= Insertion =======", false, false);
        inputArray = new int[numberOfElements];
        n = numberOfElements;
        displaysMessage(0, "Forming an array with " + inputArray.length + " elements:", true, false);
        formsData(numberOfElements);
        int i = 0;
        for (int data: set) {
            displaysMessage(0, " * Insert: " + data, true, false);
            inputArray[i++] = data;
        }
        initialArray = Arrays.copyOf(inputArray, inputArray.length);
        displaysMessage("Array: " + Arrays.toString(initialArray), false, true);
    }

    private static void countingSort() {
        int maximumAbsoluteValue = 1;
        for (int number: inputArray) {
            maximumAbsoluteValue = Math.max(Math.abs(number), maximumAbsoluteValue);
        }
        valueFrequency = new int[2 * maximumAbsoluteValue + 1];

        for (int number: inputArray) {
            valueFrequency[number + maximumAbsoluteValue]++;
        }

        int j = 0;
        for (int i = 0; i < valueFrequency.length; i++) {
            while (valueFrequency[i] > 0) {
                inputArray[j++] = i - maximumAbsoluteValue;
                valueFrequency[i]--;
            }
        }
    }

    public static void main(String[] args) {
        insertion();
        countingSort();
        displaysChange();
    }
}