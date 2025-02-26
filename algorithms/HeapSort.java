import java.util.Arrays;

class HeapSort extends BasicOperations {
    private static int n;
    private static int[] inputArray;
    private static int[] initialArray;

    private static void displaysChange() {
        displaysMessage(0, "======= Heap Sort =======", false, false);
        displaysMessage(" * Before:\t" + Arrays.toString(initialArray), true, false);
        displaysMessage(" * After:\t" + Arrays.toString(inputArray), false, true);
    }

    protected static void swap(int[] n, int a, int b) {
        int temp = n[a];
        n[a] = n[b];
        n[b] = temp;
    }

    private static void heapSort() {
        for (int i = n - 1; i > 0; i--) {
            swap(inputArray, i, 0);
            heapify(inputArray, i, 0);
        }
    }

    private static void heapify() {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(inputArray, n, i);
        }
    }

    private static void heapify(int[] n, int heapSize, int rootIndex) {
        int largestElementIndex = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        if (leftChildIndex < heapSize && n[leftChildIndex] > n[largestElementIndex]) {
            largestElementIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && n[rightChildIndex] > n[largestElementIndex]) {
            largestElementIndex = rightChildIndex;
        }
        if (largestElementIndex != rootIndex) {
            swap(n, rootIndex, largestElementIndex);
            heapify(n, heapSize, largestElementIndex);
        }
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

    public static void main(String[] args) {
        insertion();
        heapify();
        heapSort();
        displaysChange();
    }

}
