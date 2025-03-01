import java.util.Arrays;
import java.util.ArrayList;

class LinearSearch extends BasicOperations {
    private static int[] inputArray;

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
        displaysMessage(" * Array:\t" + Arrays.toString(inputArray), false, false);
        displaysLine();
    }
    
    private static void linearSearch() {
        displaysMessage(0, "======= Linear Search =======", false, false);
        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> elementsCheckedList = new ArrayList <> ();
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }

            boolean isKeyFound = false;
            for (int j = 0; j < inputArray.length; j++) {
                elementsCheckedList.add(inputArray[j]);
                if (inputArray[j] == key) {
                    isKeyFound = true;
                    break;
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

    private void run() {
        insertion();
        linearSearch();
    }

    public static void main(String[] args) {
        insertion();
        linearSearch();
    }

}
