import java.util.ArrayList;
import java.util.List;

class LinearSearch extends BasicOperations {
    private int[] inputArray;

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
        displaysArray();
        displaysLine();
    }
    
    private void linearSearch() {
        displaysMessage(0, "======= Linear Search =======", false, false);
        displaysArray();
        for (int i = 0; i < 2; i++) {
            List<Integer> elementsCheckedList = new ArrayList <> ();
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
        LinearSearch obj = new LinearSearch();
        obj.run();
    }

}
