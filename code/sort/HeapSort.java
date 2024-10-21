import java.util.Arrays;

class HeapSort extends BasicOperations {
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
        displaysMessage(0, "======= Heap Sort =======", false, false);
        displaysArray(" * Before:\t[", initialArray, true, false);
        displaysArray(" * After:\t[", inputArray, false, true);
    }

    private void heapSort() {
        maxHeapify();
        for (int i = inputArray.length - 1; i > 0; i--) {
            // 1. Extract the root of the current max heap of elements
            // by replacing the root (maximum element) 
            // with the last element of the current max heap of elements
            // this ensures that the maximum element of the current iteration
            // is at it's final sorted position
            swap(i, 0);
            
            // 2. Max-heapify all elements before the current element
            // until the max heap is of size 1
            // At the end, the array is in sorted ascending order
            maxHeapify(i, 0);
        }
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

    private void maxHeapify() {
        for (int i = inputArray.length - 1; i >= 0; i--) {
            maxHeapify(inputArray.length, i);
        }
    }

    private void maxHeapify(int numberOfElements, int parentIndex) {
        int largestIndex = parentIndex;   
        int leftChildIndex = (2 * parentIndex) + 1;        
        int rightChildIndex = (2 * parentIndex) + 2;  
        
        // 1. Finds largest value between a parent and its children
        // First part of expression is to ensure no array out of bounds exception thrown
        if (leftChildIndex < numberOfElements && inputArray[leftChildIndex] > inputArray[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < numberOfElements && inputArray[rightChildIndex] > inputArray[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        // 2. If any of the children are larger than the parent, swap that child with the parent,
        // and MaxHeapify the the array based on the largest element found so far
        if (largestIndex != parentIndex) {
            swap(parentIndex, largestIndex);
            maxHeapify(numberOfElements, largestIndex);
        }
    }

    private void swap(int parentIndex, int largestIndex) {
        int temp = inputArray[parentIndex];
        inputArray[parentIndex] = inputArray[largestIndex];
        inputArray[largestIndex] = temp;
    }
    
    private void run() {
        insertion();
        heapSort();
        displaysChange();
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        obj.run();
    }

}
