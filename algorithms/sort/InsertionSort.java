import java.util.Arrays;

class InsertionSort extends BasicOperations {
    private int[] initialArray;
    private int[] inputArray;

    private void displaysArray(String sentence, int[] inputArray, boolean isDisplaysNewLine, boolean isDisplaysLine) {
        displaysMessage(1, sentence, false, false);
        for (int i = 0; i < inputArray.length - 1; i++) {
            displaysMessage(1, inputArray[i] + " ", false, false);
        }
        displaysMessage(1, inputArray[inputArray.length - 1] + "]", true, false);
        if (isDisplaysNewLine) {
            displaysNewLine();
        }
        if (isDisplaysLine) {
            displaysLine();
        }
    }

    private void displaysChange() {
        System.out.println("======= Bubble Sort =======");
        displaysArray(" * Before:\t[", initialArray, true, false);
        displaysArray(" * After:\t[", inputArray, false, true);
    }

    private void insertion() {
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
        displaysArray("Array: [", inputArray, false, true);
    }

    private void insertionSort() {
        for (int i = 1; i < inputArray.length; i++) {
            int currentElement = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > currentElement) {
                inputArray[j + 1] = inputArray[j--];
            } 
            inputArray[j + 1] = currentElement;
        }
    }

    private void run() {
        insertion();
        insertionSort();
        displaysChange();
    }

    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        obj.run();
    }

}
