import java.util.Arrays;

public class BinaryMinHeap extends BasicOperations {
    private int[] initialArray;
    private int[] inputArray;

    private void deletion() {
        displaysMessage("======== Deletion ========", false, false);
        int indexOfDeletion = myRandom.nextInt(0, inputArray.length);
        displaysMessage("Deletion at index " + indexOfDeletion + ": " + inputArray[indexOfDeletion], true, false);
        displaysArray(" * Before:\t[", inputArray, false, true);
        inputArray = deletion(indexOfDeletion);
        displaysArray(" * After:\t[", inputArray, false, true);
        initialArray = storesInitialArray();
        minHeapify();
        displaysChange();
    }

    private int[] deletion(int indexOfDeletion) {
        set.remove(inputArray[indexOfDeletion]);
        int[] updatedArray = new int[inputArray.length - 1];
        int j = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != indexOfDeletion) {
                updatedArray[j++] = inputArray[i];
            }
        }
        return updatedArray;
    }

    private void displaysArray(String sentence, int[] array, boolean isDisplaysLine, boolean isDisplayTwoLines) {
        System.out.print(sentence);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] + "]");
        if (isDisplaysLine) {
            displaysNewLine();
            displaysLine();
        }
        if (isDisplayTwoLines) {
            displaysTwoNewLines();
        }
    }

    private void displaysChange() {
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false, true);
        displaysArray(" * After:\t[", inputArray, true, false);
    }

    private void insertion() {
        displaysLine();
        displaysMessage("======= Insertion =======", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        inputArray = new int[numberOfElements];
        displaysMessage("Forming a Binary Min Heap with " + numberOfElements + " elements:", true, false);
        formsData(numberOfElements);
        int i = 0;
        for (int data: set) {
            displaysMessage(" * Insert: " + data, false, false);
            inputArray[i++] = data;
        }
        initialArray = storesInitialArray();
        minHeapify();
        displaysChange();
    }

    private void minHeapify() {
        displaysMessage("Min-heapify:", false, false);
        for (int i = inputArray.length - 1; i >= 0; i--) {
            minHeapify(inputArray, i);
        }
    }

    private void minHeapify(int[] inputArray, int currentIndex) {
        // 1. Check if child < parent
        // First part of condition ensures no array out of bounds by confirming this is a check on a non-leaf element
        int parentIndex = currentIndex;
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        
        if (leftChildIndex < inputArray.length && inputArray[leftChildIndex] < inputArray[parentIndex]) {
            parentIndex = leftChildIndex;
        }
        if (rightChildIndex < inputArray.length && inputArray[rightChildIndex] < inputArray[parentIndex]) {
            parentIndex = rightChildIndex;
        }

        // 2. If a child > parent, swap the elements
        // and min-heapify subtree is either the left or right child of the parent elmenet
        if (parentIndex != currentIndex) {
            swap(currentIndex, parentIndex);
            minHeapify(inputArray, parentIndex);
        }
    }

    private void search() {
        displaysMessage("======== Search ========", false, false);
        displaysArray("Array:\t[", inputArray, false, true);
        for (int i = 0; i < 2; i++) {
            int key;
            boolean isKeyFound = false;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[j] == key) {
                    isKeyFound = true;
                    break;
                }
            }
            if (isKeyFound) {
                displaysMessage(" * " + key + " is in the Binary Min Heap", true, false);
            } else {
                displaysMessage(" * " + key + " is not in the Binary Min Heap", true, false);
            }
        }

        for (int data: inputArray) {
            maximum = Math.max(maximum, data);
            minimum = Math.min(minimum, data);
        }
        displaysMessage(" * Maximum: " + maximum, true, false);
        displaysMessage(" * Minimum: " + minimum, false, true);
    }

    private int[] storesInitialArray() {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    private void swap(int smallestElementIndex, int currentIndex) {
        int temp = inputArray[currentIndex];
        inputArray[currentIndex] = inputArray[smallestElementIndex];
        inputArray[smallestElementIndex] = temp;
    }
    
    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) {
        BinaryMinHeap obj = new BinaryMinHeap();
        obj.run();
    }

}
