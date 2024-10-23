import java.util.Random;
import java.util.Stack;

public class StackExample extends BasicOperations {

    private Stack<Integer> myStack = new Stack<> ();

    private void displaysStack() {
        System.out.println("Stack:\t" + myStack);
    }

    private void explanation() {
        displaysLine();
        displaysMessage("=========== Explanation ============", false, false);
        displaysMessage("Stack is a linear and dynamic data structure that operates on a LIFO principle: Last In First Out", true, false);
        displaysMessage("Key stack operations based on the Java API: ", true, false);
        displaysMessage(" * push(Element e): Pushes object/element into top of the stack", true, false);
        displaysMessage(" * peek(): Retrieves, but does not remove, object/element at top of the stack", true, false);
        displaysMessage(" * pop(): Removes the object at the top of the stack", true, false);
        displaysMessage(" * isEmpty(): Returns true only if stack is empty, else return false", true, false);
        displaysMessage(" * search(Element e): Returns 1-based position where object/object/element is on the stack, else return -1 if object not in stack", true, false);
        displaysMessage(" * clear(): Removes all object/elements in stack", true, false);
        displaysMessage(" * size(): Obtains number of object/elements in stack", true, false);
        displaysMessage(" * get(int index): Retrieves object/element at position index. Note: Ensure index <= size of stack", true, false);
        displaysMessage(" * contains(Element e): Returns true if stack contains specified object/object/element, else return false", false, true);
    }

    private int formsIndex() {
        return myRandom.nextInt(0, myStack.size());
    }

    private void insertion() {
        displaysMessage("============ Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        displaysMessage("Forming a Stack with " + numberOfElements + " elements:", true, false);
        formsData(numberOfElements);
        for (Integer data: set) {
            System.out.println(" * Insert: " + data);
            myStack.push(data);
        }
        displaysNewLine();
        displaysStack();
        displaysLine();
    }

    private void operations() {
        displaysMessage("============ Operations ============", false, false);
        displaysStack();
        displaysNewLine();
        int index;
        int key;

        displaysMessage(" * peek(): " + myStack.peek(), true, false);
        displaysMessage(" * isEmpty(): " + myStack.isEmpty(), true, false);
        displaysMessage(" * size(): " + myStack.size(), true, false);

        key = formsData(true);
        displaysMessage((" * contains(" +  key + "): " + myStack.contains(key) + " | search(" +  key + "): " + myStack.search(key)).toString(), true, false);

        key = formsData(false);
        displaysMessage((" * contains(" +  key + "): " + myStack.contains(key) + " | search(" +  key + "): " + myStack.search(key)).toString(), true, false);

        index = formsIndex();
        displaysMessage((" * get(" + index + "): " + myStack.get(index)).toString(), true, false);

        myStack.pop();
        displaysMessage((" * pop()\t| Stack: " + myStack).toString(), true, false);

        int data = formsData(false);
        displaysMessage((" * push(" + myStack.push(data) + ")\t| Stack: " + myStack).toString(), false, true);
    }

    private void run() {
        explanation();
        insertion();
        operations();
    }

    public static void main(String[] args) {
        StackExample obj = new StackExample();
        obj.run();
    }
}
