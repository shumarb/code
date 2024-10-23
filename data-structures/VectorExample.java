import java.util.Vector;

class VectorExample extends BasicOperations {

    private Vector <Integer> vector = new Vector<>();

    private void displaysVector(String message, boolean isDisplayNewLine, boolean isDisplayTwoNewLines, boolean isDisplayLine) {
        System.out.print(message + "Vector: " + vector);
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

    private void explanation() {
        displaysLine();
        displaysMessage("=========== Explanation ============", false, false);
        displaysMessage("A Vector is a linear and dynamic data structure that operates as a resizable array", true, false);
        displaysMessage("Key Vector operations based on the Vector Java API: ", true, false);
        displaysMessage(" * add(Element e): Add the specified element to end of the Vector", true, false);
        displaysMessage(" * add(int index, Element e): Add the specified element at the specified index of Vector", true, false);
        displaysMessage(" * clear(): Remove all elements in the Vector", true, false);
        displaysMessage(" * contains(Element e): Return true if the Vector contains specified element, else return false", true, false);
        displaysMessage(" * get(int index): Retrieve the element at the specified index of the Vector. Note: Ensure 0 <= index < size of the Vector", true, false);
        displaysMessage(" * isEmpty(): Return true if the Vector is empty, else return false", true, false);
        displaysMessage(" * indexOf(Element e): Returns the index of the first occurrence of the specified element in the Vector, or -1 if this list does not contain the element", true, false);
        displaysMessage(" * remove(int index): Remove the element at specified index of the Vector", true, false);
        displaysMessage(" * set(int index, Element e): Replace the current element at the specified index of Vector with the specified element", true, false);
        displaysMessage(" * size(): Obtain number of the elements in the Vector", false, true);
    }

    private int formsIndex() {
        return myRandom.nextInt(0, vector.size());
    }

    private void insertion() {
        displaysMessage("=========== Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        int i = 0;
        System.out.println("Forming an Vector with " + numberOfElements + " elements:");
        displaysNewLine();
        formsData(numberOfElements);
        for (Integer data: set) {
            System.out.println(" * Insert: " + data);
            vector.add(i++, data);
        }
        displaysNewLine();
        displaysVector("", true, false, true);
    }

    private void operations() {
        displaysMessage("=========== Operations ============", false, false);
        displaysVector("", false, true, false);
        int index;
        int key;

        System.out.println(" * isEmpty(): " + vector.isEmpty());
        displaysNewLine();

        key = formsData(true);
        System.out.print(" * contains(" +  key + "): " + vector.contains(key));
        System.out.println(", indexOf(" +  key + "): " + vector.indexOf(key));
        displaysNewLine();

        key = formsData(false);
        System.out.print(" * contains(" +  key + "): " + vector.contains(key));
        System.out.println(", indexOf(" +  key + "): " + vector.indexOf(key));
        displaysNewLine();

        System.out.println(" * size(): " + vector.size());
        displaysNewLine();

        index = formsIndex();
        System.out.println(" * get(" + index + "): " + vector.get(index));
        displaysNewLine();

        index = formsIndex();
        key = formsData(false);
        vector.set(index, key);
        System.out.print(" * set(" + index + ", " + key + ")");
        displaysVector("\t\t| ", false, true, false);

        index = formsIndex();
        key = formsData(false);
        vector.add(index, key);
        System.out.print(" * add(" + index + ", " + key + ")");
        displaysVector("\t\t| ", false, true, false);

        key = formsData(false);
        vector.add(key);
        System.out.print(" * add(" + key + ")");
        displaysVector("\t\t| ", false, true, false);

        index = formsIndex();
        System.out.print(" * remove(" + index + "): " + vector.remove(index));
        displaysVector("\t| ", true, false, true);
    }

    private void search() {
        displaysMessage("=========== Search ============", false, false);
        displaysVector("", false, true, false);
        for (int i = 1; i < vector.size(); i++) {
            maximum = Math.max(maximum, vector.get(i));
            minimum = Math.min(minimum, vector.get(i));
        }
        System.out.println(" * Maximum: " + maximum);
        displaysNewLine();
        System.out.println(" * Minimum: " + minimum);
        displaysLine();
    }

    private void run() {
        explanation();
        insertion();
        operations();
        search();
    }

    public static void main(String[] args) {
        VectorExample obj = new VectorExample();
        obj.run();
    }
}
