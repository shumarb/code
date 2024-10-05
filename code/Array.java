import java.util.ArrayList;

class Array extends BasicOperations {
    private int[] inputArray;

    private void deletion() {
        System.out.println("============ Deletion ============");
        System.out.print("Before deletion: ");
        displaysArray();
        displaysNewLine();
        int indexOfDeletion = myRandom.nextInt(0, inputArray.length);
        System.out.println(" * Deletion at index " + indexOfDeletion + ": " + inputArray[indexOfDeletion]);
        inputArray = deletion(indexOfDeletion);
        displaysNewLine();
        System.out.print("After deletion: ");
        displaysArray();
        displaysLine();
    }

    private int[] deletion(int indexOfDeletion) {
        int[] updatedArray = new int[inputArray.length - 1];
        int j = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != indexOfDeletion) {
                updatedArray[j++] = inputArray[i];
            }
        }
        return updatedArray;
    }

    private void displaysArray() {
        System.out.print("Array: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    private void insertion() {
        int numberOfElements = myRandom.nextInt(5, 12);
        int i = 0;
        inputArray = new int[numberOfElements];
        System.out.println("============ Insertion ============");
        System.out.println("Forming an Array with " + inputArray.length + " elements:");
        displaysNewLine();
        formsData(numberOfElements);
        for (int data: set) {
            System.out.println(" * Insert: " + data);
            inputArray[i++] = data;
        }
        displaysNewLine();
        displaysArray();
        displaysLine();
    }
    
    private void search() {
        System.out.println("============ Search ============");
        displaysArray();

        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> elementsChecked = new ArrayList<> ();
            boolean isKeyFound = false;
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                 key = formsData(false);
            }
            for (int j = 0; j < inputArray.length; j++) {
                elementsChecked.add(inputArray[j]);
                if (key == inputArray[j]) {
                    isKeyFound = true;
                    break;
                }
            }
            displaysNewLine();
            if (isKeyFound) {
                System.out.print(" * " + key + " is in array");
            } else {
                System.out.print(" * " + key + " is not in array");
            }
            System.out.println(", number of checks: " + elementsChecked.size() + ", elements checked: " + elementsChecked);
        }
        displaysNewLine();

        for (int i = 1; i < inputArray.length; i++) {
            maximum = Math.max(maximum, inputArray[i]);
            minimum = Math.min(minimum, inputArray[i]);
        }
        System.out.println(" * " + "Maximum: " + maximum);
        displaysNewLine();
        System.out.println(" * " + "Minimum: " + minimum);
        displaysLine();
    }

    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) {
        Array obj = new Array();
        obj.run();
    }
}
