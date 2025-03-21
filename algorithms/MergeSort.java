import java.util.Arrays;

class MergeSort extends BasicOperations {
    private static int[] initialArray;
    private static int[] inputArray;

    private static void displaysChange() {
        displaysMessage(0, "======= Merge Sort =======", false, false);
        displaysMessage(" * Before:\t" + Arrays.toString(initialArray), true, false);
        displaysMessage(" * After:\t" + Arrays.toString( inputArray), false, true);
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

    private static void merge(int[] inputArray, int[] leftPartitionArray, int[] rightPartitionArray) {
        int inputArrayIterator = 0;                                 
        int leftPartitionArrayIterator = 0;                         
        int leftPartitionArraySize = leftPartitionArray.length;
        int rightPartitionArrayIterator = 0;                        
        int rightPartitionArraySize = rightPartitionArray.length;

        while (leftPartitionArrayIterator < leftPartitionArraySize && rightPartitionArrayIterator < rightPartitionArraySize) {
            // 1. Compare i-th element of leftPartitionArray with j-th element of rightPartitionArray
            if (leftPartitionArray[leftPartitionArrayIterator] <= rightPartitionArray[rightPartitionArrayIterator]) {
                // 1.1. i-th element of leftPartitionArray <= j-th element of rightPartitionArray,
                // so add i-th element of leftPartitionArray to k-th index of inputArray
                // and increment both iterators to refer to next element
                inputArray[inputArrayIterator++] = leftPartitionArray[leftPartitionArrayIterator++];
            } else {
                // 1.2. i-th element of leftPartitionArray > j-th element of rightPartitionArray,
                // so add j-th element of rightPartitionArray to k-th index of inputArray
                // and increment both iterators to refer to next element
                inputArray[inputArrayIterator++] = rightPartitionArray[rightPartitionArrayIterator++];
            }
        }

        // 2. At this point, it is possible that >= 1 element from at most one of the arrays
        // was not added to inputArray at correct index,
        // so add these elements into inputArray at correct index if it has not been done
        while (leftPartitionArrayIterator < leftPartitionArraySize) {
            inputArray[inputArrayIterator++] = leftPartitionArray[leftPartitionArrayIterator++];
        }
        while (rightPartitionArrayIterator < rightPartitionArraySize) {
            inputArray[inputArrayIterator++] = rightPartitionArray[rightPartitionArrayIterator++];
        }
    }

    private static void mergeSort() {
        mergeSort(inputArray);
    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        // 1. Obtain index of middle element (midIndex) of inputArray
        // Split inputArray into 2 arrays: leftPartitionArray and rightPartitionArray
        // leftPartitionArray comprises of elements 0 to midIndex of inputArray
        // rightPartitionArray comprises of elements from midIndex + 1 to lastArrayIterator of inputArray
        // Note: copyOfRange range is [from, to), meaning [from, to - 1]
        int midIndex = inputLength / 2;
        int[] leftPartitionArray = Arrays.copyOfRange(inputArray, 0, midIndex);
        int[] rightPartitionArray = Arrays.copyOfRange(inputArray, midIndex, inputLength);

        // 2. Execute Merge Sort on the left and right partitions
        mergeSort(leftPartitionArray);
        mergeSort(rightPartitionArray);

        // 3. Combine the sub-array,
        // and assign each element in the combined sub-array to
        // the corresponding index of the input array
        merge(inputArray, leftPartitionArray, rightPartitionArray);
    }

    public static void main(String[] args) {
        insertion();
        mergeSort();
        displaysChange();
    }

}
