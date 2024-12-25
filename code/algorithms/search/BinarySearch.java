package code;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch extends BasicOperations {
    private int[] inputArray;

    private void binarySearch() {
        displaysMessage(0, "======= Binary Search =======", false, false);
        displaysArray();
        
        for (int i = 0; i < 2; i++) {
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }

            boolean isKeyFound = false; 
            List<Integer> elementsCheckedList = new ArrayList<> ();
            int highIndex = inputArray.length - 1;
            int lowIndex = 0;
            
            while (lowIndex <= highIndex) {
                int midIndex = (highIndex + lowIndex) / 2;
                int middleElement = inputArray[midIndex];
                elementsCheckedList.add(middleElement);
                if (middleElement == key) {
                    isKeyFound = true;
                    break;
                } else {
                    if (middleElement < key) {
                        // Iignore all elements <= middleElement
                        lowIndex = midIndex + 1;
                    } else {
                        // Ignore all elements > middleElement
                        highIndex = midIndex - 1;
                    }
                }
            }

            displaysNewLine();
            if (isKeyFound) {
                displaysMessage(1, " * " + key + " is in the array\t\t| ", false, false);
            } else {
                displaysMessage(1, " * " + key + " is not in the array\t| ", false, false);
            }
            displaysMessage(0, "Elements checked: " + elementsCheckedList, false, false);
        }
        displaysLine();
    }

    private void displaysArray() {
        System.out.print("Array: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    private void insertion() {
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
        Arrays.sort(inputArray);
        displaysArray();
        displaysLine();
    }
    
    private void run() {
        insertion();
        binarySearch();
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        obj.run();
    }

}
