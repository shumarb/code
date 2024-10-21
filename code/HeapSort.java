import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class HeapSort {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

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

    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysMessage(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
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

    private void displaysNewLine() {
        System.out.println();
    }

    private void formsData() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = formsData(false);
        int order = myRandom.nextInt(0, 2);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 0) {
                // Descending order of number to be inserted into the Array
                // because merge sort sorts the elements in ascending order
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    private int formsData(boolean isDataPresent) {
        int data;
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
        formsData();
        inputArray = new int[set.size()];
        displaysMessage(0, "Forming an array with " + inputArray.length + " elements:", true, false);
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
