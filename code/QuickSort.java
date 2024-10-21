import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class QuickSort {

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
        displaysMessage(0, "======= Quick Sort =======", false, false);
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
                // because Quick Sort sorts the elements in ascending order
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

    private int partition(int[] inputArray, int lowIndex, int highIndex) {
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

    private void quickSort() {
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    private void quickSort(int[] inputArray, int lowIndex, int highIndex) {
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

    private void swap(int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }

    private void run() {
        insertion();
        quickSort();
        displaysChange();
    }
    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        obj.run();
    }
}
