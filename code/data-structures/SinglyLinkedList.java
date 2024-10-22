import java.util.HashSet;
import java.util.Random;

class SinglyLinkedList extends BasicOperations {
    private Node head;

    private Node findsLastNode(Node currentNode) {
        if (currentNode.isLastNode()) {
            return currentNode;
        }

        return findsLastNode(currentNode.getsNextNode());
    }

    private Node getsElement(int index) {
        int count = 1;
        Node currentNode = head.getsNextNode();
        while (currentNode != null) {
            if (count++ == index) {
                break;
            }
            currentNode = currentNode.getsNextNode();
        }
        return currentNode;
    }

    private void deletion() {
        displaysMessage("============ Deletion ============", false, false);
        int numberOfElements = 0;
        Node currentNode = head.getsNextNode();
        while (currentNode != null) {
            numberOfElements++;
            currentNode = currentNode.getsNextNode();
        }

        int indexOfDeletion = myRandom.nextInt(1, numberOfElements);
        displaysMessage("Deletion of element #" + indexOfDeletion + ": " + getsElement(indexOfDeletion).getsData(), true, false);
        traversal(" * Before:\t", true, false);
        
        // 1. Delete first element
        if (indexOfDeletion == 1) {
            Node newFirstNode = head.getsNextNode().getsNextNode();
            Node toRemoveNode = head.getsNextNode();
            toRemoveNode.setsNextNode(null);
            head.setsNextNode(newFirstNode);
        } else if (indexOfDeletion == numberOfElements) {
            // 2. Delete last element
            int currentIndex = 0;
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                currentIndex++;
                if (currentIndex == (indexOfDeletion - 1)) {
                    currentNode.setsNextNode(null);
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }
        } else {
            // 3. Delete element between first and last elements
            int currentIndex = 0;
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                currentIndex++;
                if (currentIndex == (indexOfDeletion - 1)) {
                    Node toRemoveNode = currentNode.getsNextNode();
                    Node newNextNode = toRemoveNode.getsNextNode();
                    currentNode.setsNextNode(newNextNode);
                    toRemoveNode.setsNextNode(null);
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }
        }
        displaysNewLine();
        traversal(" * After:\t", false, true);
        displaysLine();
    }

    private void insertion() {
        displaysLine();
        displaysMessage("============ Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        displaysMessage("Forming a Singly Linked List with " + numberOfElements + " elements:", true, false);
        formsData(numberOfElements);
        for (Integer data: set) {
            Node incomingNode = new Node(data);
            displaysMessage(" * Insert: " + incomingNode.getsData(), false, false);
            if (head == null) {
                head = new Node(-1);
                head.setsNextNode(incomingNode);
            } else {
                Node lastNode = findsLastNode(head.getsNextNode());
                lastNode.setsNextNode(incomingNode);
            }
        }
        displaysNewLine();
        traversal("Singly Linked List:\t", false, true);
        displaysLine();
    }

    private void search() {
        displaysMessage("============ Search ============", false, false);
        traversal("Singly Linked List:\t", true, false);
        displaysNewLine();
        int key = formsData(false);
        Node currentNode;
        for (int i = 0; i < 2; i++) {
            boolean isKeyFound = false;
            currentNode = head.getsNextNode();
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                if (currentNode.getsData() == key) {
                    isKeyFound = true;
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }

            if (isKeyFound) {
                displaysMessage(" * " + key + " is in Singly Linked List", true, false);
            } else {
                displaysMessage(" * " + key + " is not in Singly Linked List", true, false);
            }
        }

        currentNode = head.getsNextNode();
        int maximum = currentNode.getsData();
        int minimum = currentNode.getsData();
        while (currentNode != null) {
            maximum = Math.max(maximum, currentNode.getsData());
            minimum = Math.min(minimum, currentNode.getsData());
            currentNode = currentNode.getsNextNode();
        }
        displaysMessage(" * Maximum: " + maximum, true, false);
        displaysMessage(" * Minimum: " + minimum, false, true);
    }

    private void traversal(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        displaysMessage(message + "HEAD ---> ");
        Node currentNode = head.getsNextNode();
        while (currentNode != null) {
            displaysMessage(Integer.toString(currentNode.getsData()));
            if (currentNode.getsNextNode() == null) {
                break;
            } else {
                displaysMessage(" ---> ");
            }
            currentNode = currentNode.getsNextNode();
        }
        displaysNewLine();
    }


    private void run() {
        insertion();
        search();
        deletion();
    }
    public static void main(String[] args) {
        SinglyLinkedList obj = new SinglyLinkedList();
        obj.run();
    }
}

class Node {
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public boolean hasNextNode() {
        return this.nextNode != null;
    }

    public boolean isLastNode() {
        return this.nextNode == null;
    }

    public int getsData() {
        return this.data;
    }

    public Node getsNextNode() {
        return this.nextNode;
    }

    public void setsNextNode(Node incomingNode) {
        this.nextNode = incomingNode;
    }
}
