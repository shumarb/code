import java.util.Arrays;

class SelectionSort extends BasicOperations {
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
        displaysMessage(0, "======= Selection Sort =======", false, false);
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

    private void selectionSort() {
        for (int startIndex = 0; startIndex < inputArray.length - 1; startIndex++) {
            boolean isSorted = true;
            for (int nextIndex = startIndex + 1; nextIndex < inputArray.length; nextIndex++) {
                if (inputArray[nextIndex] < inputArray[startIndex]) {
                    isSorted = false;
                    swap(nextIndex, startIndex);
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp; 
    }

    private void run() {
        insertion();
        selectionSort();
        displaysChange();
    }
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        obj.run();
    }
}
