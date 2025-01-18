import java.util.Arrays;

class SelectionSort extends BasicOperations {
    private static int[] initialArray;
    private static int[] inputArray;

    private static void displaysChange() {
        displaysMessage(0, "======= Selection Sort =======", false, false);
        displaysMessage(" * Before:\t" + Arrays.toString(initialArray), true, false);
        displaysMessage(" * After:\t" + Arrays.toString(inputArray), false, true);
    }

    protected static void swap(int[] n, int a, int b) {
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
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

    private static void selectionSort() {
        int n = inputArray.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (inputArray[j] < inputArray[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(inputArray, i, minIndex);
            }
        }
    }

   public static void main(String[] args) {
        insertion();
        selectionSort();
        displaysChange();
    }

}
