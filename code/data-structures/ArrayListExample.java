import java.util.List;
import java.util.ArrayList;

class ArrayListExample extends BasicOperations {
    private List<Integer> arrayList = new ArrayList<> ();
    
    private void displaysArrayList(String message, boolean isDisplayNewLine, boolean isDisplayTwoNewLines, boolean isDisplayLine) {
        System.out.print(message + "ArrayList: " + arrayList);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayTwoNewLines) {
            displaysTwoNewLines();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private void displaysMessage(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        System.out.println(message);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private void explanation() {
        displaysLine();
        displaysMessage("=========== Explanation ============", false, false);
        displaysMessage("An ArrayList is a linear and dynamic data structure that operates as a resizable array", true, false);
        displaysMessage("Key ArrayList operations based on the ArrayList Java API: ", true, false);
        displaysMessage(" * add(Element e): Add the specified element to end of the ArrayList", true, false);
        displaysMessage(" * add(int index, Element e): Add the specified element at the specified index of ArrayList", true, false);
        displaysMessage(" * clear(): Remove all elements in the ArrayList", true, false);
        displaysMessage(" * contains(Element e): Return true if the ArrayList contains specified element, else return false", true, false);
        displaysMessage(" * get(int index): Retrieve the element at the specified index of the ArrayList. Note: Ensure 0 <= index < size of the ArrayList", true, false);
        displaysMessage(" * isEmpty(): Return true if the ArrayList is empty, else return false", true, false);
        displaysMessage(" * indexOf(Element e): Returns the index of the first occurrence of the specified element in the ArrayList, or -1 if this list does not contain the element", true, false);
        displaysMessage(" * remove(int index): Remove the element at specified index of the ArrayList", true, false);
        displaysMessage(" * set(int index, Element e): Replace the current element at the specified index of ArrayList with the specified element", true, false);
        displaysMessage(" * size(): Obtain number of the elements in the ArrayList", false, true);
    }

    private int formsIndex() {
        if (arrayList.isEmpty()) {
            return -1;
        }
        return myRandom.nextInt(0, arrayList.size());
    }

    private void insertion() {
        displaysMessage("============ Insertion ============", false, false);
        int numberOfElements = set.size();
        displaysMessage("Forming an ArrayList with " + numberOfElements + " elements:", true, false);
        for (Integer data: set) {
            System.out.println(" * Insert: " + data);
            displaysNewLine();
            arrayList.add(data);
        }
        displaysArrayList("", true, false, true);
    }

    private void operations() {
        displaysMessage("=========== Operations ============", false, false);
        displaysArrayList("", false, true, false);
        int index;
        int key;

        displaysMessage(" * size(): " + arrayList.size(), true, false);
        displaysMessage(" * isEmpty(): " + arrayList.isEmpty(), true, false);

        key = retrievesData();
        displaysMessage(" * contains(" +  key + "): " + arrayList.contains(key) + "\t| indexOf(" +  key + "): " + arrayList.indexOf(key), true, false);
        key = formsData(false);
        displaysMessage(" * contains(" +  key + "): " + arrayList.contains(key) + "\t| indexOf(" +  key + "): " + arrayList.indexOf(key), true, false);

        if (!arrayList.isEmpty()) {
            index = formsIndex();
            displaysMessage(" * get(" + index + "): " + arrayList.get(index), true, false);
        }

        index = formsIndex();
        key = formsData(true);
        arrayList.set(index, key);
        System.out.print(" * set(" + index + ", " + key + ")");
        displaysArrayList("\t\t| ", false, true, false);

        index = formsIndex();
        key = formsData(false);
        arrayList.add(index, key);
        System.out.print(" * add(" + index + ", " + key + ")");
        displaysArrayList("\t\t| ", false, true, false);

        key = formsData(false);
        arrayList.add(key);
        System.out.print(" * add(" + key + ")");
        displaysArrayList("\t\t| ", false, true, false);

        if (!arrayList.isEmpty()) {
            index = formsIndex();
            System.out.print(" * remove(" + index + "): " + arrayList.remove(index));
            displaysArrayList("\t| ", true, false, true);
        }
    }

    private int retrievesData() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("ArrayList is empty.");
        }
        return arrayList.get(myRandom.nextInt(0, arrayList.size() - 1));
    }

    private void search() {
        displaysMessage("============ Search ============", false, false);
        displaysArrayList("", false, true, false);
        if (!arrayList.isEmpty()) {
            int maximum = arrayList.get(0);
            int minimum = arrayList.get(0);
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) > maximum) {
                    maximum = arrayList.get(i);
                }
                if (arrayList.get(i) < minimum) {
                    minimum = arrayList.get(i);
                }
            }
            displaysMessage(" * Maximum: " + maximum, true, false);
            displaysMessage(" * Minimum: " + minimum, false, true);
        } else {
            displaysMessage("ArrayList is empty. Cannot find maximum and minimum.", true, false);
        }
    }

    private void run() {
        formsData();
        explanation();
        insertion();
        operations();
        search();
    }

    public static void main(String[] args) {
        ArrayListExample obj = new ArrayListExample();
        obj.run();
    }
}
