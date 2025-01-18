import java.util.Arrays;

class InsertionSort extends BasicOperations {
    private static int[] initialArray;
    private static int[] inputArray;

    private static void displaysChange() {
        displaysMessage("======= Insertion Sort =======", false, false);
        displaysMessage(" * Before:\t" + Arrays.toString(initialArray), true, false);
        displaysMessage(" * After:\t" + Arrays.toString(inputArray), false, true);
    }

    private static void insertion() {
        displaysLine();
        displaysMessage(0, "======= Insertion =======", false, false);
        inputArray = new int[numberOfElements];
        displaysMessage(0, "Forming an array with " + inputArray.length + " elements:", true, false);
        formsData(numberOfElements);
        int i = 0;
        for (int data: set) {
            displaysMessage(0, " * Insert: " + data, true, false);
            inputArray[i++] = data;
        }
        initialArray = Arrays.copyOf(inputArray, inputArray.length);
        displaysMessage("Array: [" + Arrays.toString(inputArray), false, true);
    }

    private static void insertionSort() {
        for (int i = 1; i < inputArray.length; i++) {
            int currentElement = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > currentElement) {
                inputArray[j + 1] = inputArray[j--];
            } 
            inputArray[j + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        insertion();
        insertionSort();
        displaysChange();
    }

}
