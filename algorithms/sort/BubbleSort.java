import java.util.Arrays;

class BubbleSort extends BasicOperations {
    private static int[] initialArray;
    private static int[] inputArray;

    private static void bubbleSort() {
        int n = inputArray.length;

        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = i + 1; j < n; j++) {
                if (inputArray[i] > inputArray[j]) {
                    swap(i, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private static void displaysChange() {
        displaysMessage("======= Bubble Sort =======", false, false);
        displaysMessage(" * Before:\t" + Arrays.toString(initialArray), true, false);
        displaysMessage(" * After:\t" + Arrays.toString(inputArray), false, true);
    }

    private static void insertion() {
        displaysLine();
        displaysMessage(0, "======= Insertion =======", false, false);
        inputArray = new int[numberOfElements];
        displaysMessage(0, "Forming an array with " + numberOfElements + " elements:", true, false);
        formsData(numberOfElements);
        int i = 0;
        for (int data: set) {
            displaysMessage(0, " * Insert: " + data, true, false);
            inputArray[i++] = data;
        }
        initialArray = Arrays.copyOf(inputArray, inputArray.length);
        displaysMessage("Array: " + Arrays.toString(inputArray), false, true);
    }

    private static void swap(int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp; 
    }

    public static void main(String[] args) {
        insertion();
        bubbleSort();
        displaysChange();
    }

}
