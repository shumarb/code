import java.util.LinkedList;
import java.util.Random;

class DoublyLinkedList extends BasicOperations {
    private LinkedList <Integer> doublyLList = new LinkedList <> ();

    private void displaysDoublyLList(boolean isDisplayNewLine, boolean isDisplayLine) {
        System.out.println("Doubly Linked List: " + doublyLList);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private int formsIndex() {
        return myRandom.nextInt(0, doublyLList.size());
    }

    private void insertion() {
        displaysMessage("============ Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        displaysMessage(("Forming a Doubly Linked List with " + numberOfElements + " elements:").toString(), true, false);
        formsData(numberOfElements);
        for (Integer data: set) {
            System.out.println(" * Insert: " + data);
            doublyLList.add(data);
        }
        displaysNewLine();
        displaysDoublyLList(false, true);
    }

    private void explanation() {
        displaysLine();
        displaysMessage("=========== Explanation ============", false, false);
        displaysMessage("A Doubly Linked List is a linked list where each element pointers to both it's previous node and next nodes.", true, false);
        displaysMessage("Key Doubly Linked List operations based on the Java Linked List API: ", true, false);
        displaysMessage(" * add(Element e): Add the specified element to end of the Doubly Linked List", true, false);
        displaysMessage(" * add(int index, Element e): Add the specified element at the specified index of Doubly Linked List", true, false);
        displaysMessage(" * clear(): Remove all elements in the Doubly Linked List", true, false);
        displaysMessage(" * contains(Element e): Return true if the Doubly Linked List contains specified element, else return false", true, false);
        displaysMessage(" * get(int index): Retrieve the element at the specified index of the Doubly Linked List. Note: Ensure 0 <= index < size of the Doubly Linked List", true, false);
        displaysMessage(" * isEmpty(): Return true if the Doubly Linked List is empty, else return false", true, false);
        displaysMessage(" * peekFirst(): Retrieve, but not remove, the first element of the Doubly Linked List", true, false);
        displaysMessage(" * peekLast(): Retrieve, but not remove, the last element of the Doubly Linked List", true, false);
        displaysMessage(" * pollFirst(): Remove the first element of the Doubly Linked List", true, false);
        displaysMessage(" * pollLast(): Remove the last element of the Doubly Linked List", true, false);
        displaysMessage(" * remove(int index): Remove the element at specified index of the Doubly Linked List", true, false);
        displaysMessage(" * set(int index, Element e): Replace the current element at the specified index of Doubly Linked List with the specified element", true, false);
        displaysMessage(" * size(): Obtain number of the elements in the Doubly Linked List", false, true);
    }

    private void operations() {
        displaysMessage("=========== Operations ============", false, false);
        displaysDoublyLList(true, false);
        int index;
        int key;

        displaysMessage((" * size(): " + doublyLList.size()), true, false);
        displaysMessage((" * peek(): " + doublyLList.peek()), true, false);
        displaysMessage((" * isEmpty(): " + doublyLList.isEmpty()), true, false);
        displaysMessage(" * peekLast(): " + doublyLList.peekLast(), true, false);
        
        key = formsData(true);
        displaysMessage((" * contains(" +  key + "): " + doublyLList.contains(key)) + "\t| indexOf(" + key + "): " + doublyLList.indexOf(key), true, false);

        key = formsData(false);
        displaysMessage((" * contains(" +  key + "): " + doublyLList.contains(key)) + "\t| indexOf(" + key + "): " + doublyLList.indexOf(key), true, false);

        index = formsIndex();
        displaysMessage(" * get(" + index + "): " + doublyLList.get(index), true, false);

        index = formsIndex();
        key = formsData(false);
        doublyLList.add(index, key);
        displaysMessage(" * add(" + index + ", " + key + ")\t\t| Doubly Linked List: " + doublyLList, true, false);

        index = formsIndex();
        key = formsData(false);
        doublyLList.set(index, key);
        displaysMessage(" * set(" + index + ", " + key + ")\t\t| Doubly Linked List: " + doublyLList, true, false);

        doublyLList.pollFirst();
        displaysMessage(" * pollFirst()\t\t| Doubly Linked List: " + doublyLList, true, false);

        key = formsData(false);
        doublyLList.add(key);
        displaysMessage(" * add(" + key + ")\t\t| Doubly Linked List: " + doublyLList, false, true);
    }

    private void search() {
        displaysMessage("=========== Search ============", false, false);
        displaysDoublyLList(true, false);

        int i = 0;
        int[] doublyLListArray = new int[doublyLList.size()];
        while (!doublyLList.isEmpty()) {
            doublyLListArray[i++] = doublyLList.pollFirst();
        }
        for (i = 0; i < doublyLListArray.length; i++) {
            maximum = Math.max(maximum, doublyLListArray[i]);
            minimum = Math.min(minimum, doublyLListArray[i]);
        }
        displaysMessage(" * Maximum: " + maximum, true, false);
        displaysMessage(" * Minimum: " + minimum, false, true);
    }

    private void run() {
        explanation();
        insertion();
        operations();
        search();
    }

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.run();
    }
}
