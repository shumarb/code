import java.util.Arrays;

class QuickSort extends BasicOperations {
    private static int[] initialArray;
    private static int[] inputArray;

    private static void displaysChange() {
        displaysMessage(0, "======= Quick Sort =======", false, false);
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
        displaysMessage("Array: " + Arrays.toString(inputArray), false, true);
    }

    private static int partition(int[] inputArray, int lowIndex, int highIndex) {
        // 1. Select last element of the partition as the pivot
        int pivot = inputArray[highIndex];

        // 2. Create 2 variables,
        // with 1 pointing to the element at the lowIndex of partition,
        // and the other 1 pointing to the element at the highIndex of the partition
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while (leftPointer < rightPointer) {
            // 2a. For 2 while loops, 2nd part of condition is in case
            // leftPointer does not come across any element larger than pivot
            // and rightPointer does not come across any element smaller than pivot
            while (inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // 2b. Swap an element <= pivot with an element >= pivot
            // If condition in case leftPointer and rightPointer
            // do not encounter an element > pivot and <= pivot respectively
            if (leftPointer < rightPointer) {
                swap(leftPointer, rightPointer);
            }
        }

        // 3. Now, both leftPointer and rightPointer represents 
        // correct index that pivot has to be and highIndex represents current index of pivot
        // because at the start of program, the pivot is the last element of the partition at highIndex
        swap(leftPointer, highIndex);

        // 4. Return index of pivot, which can be either leftPointer or rightPointer
        // because both pointers are pointing to the index of the partition
        return leftPointer;
    }

    private static void quickSort() {
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    private static void quickSort(int[] inputArray, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        // 1. Select partitioning index and execute quick sort so that
        // elements smaller than pivot are on the left of the pivot and
        // elements larger than the pivot are on the right 
        int pivotIndex = partition(inputArray, lowIndex, highIndex);
        quickSort(inputArray, lowIndex, pivotIndex - 1);
        quickSort(inputArray, pivotIndex + 1, highIndex);
    }

    private static void swap(int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

    public static void main(String[] args) {
        insertion();
        quickSort();
        displaysChange();
    }

}
