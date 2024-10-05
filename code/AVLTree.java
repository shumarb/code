import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
  
public class AVLTree extends BasicOperations {
    private Node root;

    private void elementInformation(Node node) {
        displaysMessage(1, "[" + node.getsData() + ", h: " + node.getsHeight() + "]  ", false, false);
    }

    private void deletion() {
        displaysMessage(0, "======= Deletion =======", false, false);
        int key = formsData(true);
        root = deletion(root, key);
        set.remove(key);
        displaysMessage(0, "Delete: " + key, true, false);
        updatesHeight(root, "updates height of elements in left and right subtrees");
        traversal();
    }

    private Node deletion(Node node, int key) {
        if (node == null) {
            return node;
        } else if (key < node.getsData()) {
            node.setsLeftChild(deletion(node.getsLeftChild(), key));
        } else if (key > node.getsData()) {
            node.setsRightChild(deletion(node.getsRightChild(), key));
        } else {
            Node temp = null;
            if (!node.hasLeftChild() || !node.hasRightChild()) {
                temp = (temp == node.getsLeftChild()) ? node.getsRightChild() : node.getsLeftChild();

                // Deleting a leaf
                if (temp == null) {
                    temp = node;

                    // Node deleted
                    node = null;
                } else {
                    // Deleting element with 1 child
                    node = temp;
                }
            } else {
                // Deleting element with 2 children
                // Get in-order successor (smallest element in right subtree)
                temp = searchMinimum(node.getsRightChild());

                // Set current node's value to be that of it's successor
                node.setsData(temp.getsData());

                // Delete in-order successor
                node.setsRightChild(deletion(node.getsRightChild(), node.getsData()));
            }
        }
        
        // If tree has only 1 element, then return
        if (node == null) {
            return node;
        }

        updatesHeight(node, "increase");
        return rebalancesAVLTree(node);
    }

    private int getsHeight(Node node) { 
        return (node == null) ? -1 : node.getsHeight();
    } 

    private int getsBalanceFactor(Node node) { 
        return (node == null) ? 0 : getsHeight(node.getsLeftChild()) - getsHeight(node.getsRightChild()); 
    }

    private void insertion() {
        displaysLine();
        numberOfElements = myRandom.nextInt(5, 12);
        displaysMessage(0, "======= Insertion =======", false, false);
        displaysMessage(0, "Forming AVL Tree with " + numberOfElements + " elements:", true, false);
        formsData(numberOfElements);
        for (Integer data: set) {
            displaysMessage(0, " * Insert: " + data, true, false);
            root = insertion(root, data);
        }
        // AVL Tree may have a child is > 1 level below it's parent
        // Eg: element 5 is at level 3, but it's left child 4 is at level 1 and not level 2.
        // Hence, this update ensures every child is 1 level below it's parent.
        updatesHeight(root, "updates height of elements in left and right subtrees");
        traversal();
    }

    /**
     * References: 
     * https://www.geeksforgeeks.org/insertion-in-an-avl-tree/
     * https://www.baeldung.com/java-avl-trees
     */ 
    private Node insertion(Node node, int data) { 
        if (node == null) {
            return new Node(data);
        } else if (data < node.getsData()) {
            node.setsLeftChild(insertion(node.getsLeftChild(), data));
        } else if (data > node.getsData()) {
            node.setsRightChild(insertion(node.getsRightChild(), data)); 
        } 
        updatesHeight(node, "increase");
        return rebalancesAVLTree(node);
    } 
    
    /**
     * Reference: 
     * https://www.youtube.com/watch?v=TbvhGcf6UJU&ab_channel=nptelhrd, 
     * https://github.com/geekific-official/geekific-youtube/blob/main/tree-implementations/avl-tree/src/main/java/com/youtube/geekific/AVLTree.java#L94
     */
    private Node rebalancesAVLTree(Node node) {
        if (node == null) {
            return root;
        }

        int balanceFactor = getsBalanceFactor(node);

        // Left-Left imbalance ==> Right rotation
        if (balanceFactor > 1 && getsBalanceFactor(node.getsLeftChild()) >= 0) {
            return rightRotation(node);
        }

        // Left-Right imbalance ==> Left-Right rotation
        if (balanceFactor > 1 && getsBalanceFactor(node.getsLeftChild()) < 0) {
            node.setsLeftChild(leftRotation(node.getsLeftChild()));
            return rightRotation(node);
        }

        // Right-Right imbalance ==> Left rotation
        if (balanceFactor < -1 && getsBalanceFactor(node.getsRightChild()) <= 0) {
            return leftRotation(node);
        }

        // Right-Left imbalance ==> Right-Left rotation
        if (balanceFactor < -1 && getsBalanceFactor(node.getsRightChild()) > 0) {
            node.setsRightChild(rightRotation(node.getsRightChild()));
            return leftRotation(node);
        }

        return node;
    }

    private Node leftRotation(Node node) { 
        if (node == null) {
            return node;
        }

        Node rightChild = node.getsRightChild(); 
        Node centerNode = rightChild.getsLeftChild();
  
        // Left rotation 
        // node < centerNode < rightChild
        rightChild.setsLeftChild(node);
        node.setsRightChild(centerNode);
  
        updatesHeight(node, "increase");
        updatesHeight(rightChild, "increase");
  
        // Return new root
        return rightChild; 
    } 

    private Node rightRotation(Node node) { 
        if (node == null) {
            return node;
        }

        Node leftChild = node.getsLeftChild(); 
        Node centerNode = leftChild.getsRightChild();
  
        // node > centerNode > leftChild
        leftChild.setsRightChild(node);
        node.setsLeftChild(centerNode);
  
        updatesHeight(node, "increase");
        updatesHeight(leftChild, "increase");
        
        // Return new root
        return leftChild; 
    } 

    private void traversal(Node node, String traversalOrder) {
        if (node == null) {
            return;
        } else if (traversalOrder.equals("in-order")) {
            traversal(node.getsLeftChild(), traversalOrder);
            elementInformation(node);
            traversal(node.getsRightChild(), traversalOrder);
        } else if (traversalOrder.equals("pre-order")) {
            elementInformation(node);
            traversal(node.getsLeftChild(), traversalOrder);
            traversal(node.getsRightChild(), traversalOrder);
        } else if (traversalOrder.equals("post-order")) {
            traversal(node.getsLeftChild(), traversalOrder);
            traversal(node.getsRightChild(), traversalOrder);
            elementInformation(node);
        }
    }

    private void search() {
        displaysMessage(0, "======= Search =======", false, false);
        Node node;
        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> searchPath = new ArrayList <> ();
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            displaysMessage(1, "Search: " + key + "\t| ", false, false);
            node = search(root, "binary search", key, searchPath);
            if (node != null) {
                System.out.print(key + " is in the AVL Tree");
            } else {
                System.out.print(key + " is not in the AVL Tree");
            }
            searchPath(searchPath);
            displaysNewLine();
        }

        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> searchPath = new ArrayList <> ();
            if (i == 0) {
                node = search(root, "searches minimum", Integer.MIN_VALUE, searchPath);
                displaysMessage(1, "Minimum: " + node.getsData(), false, false);
            } else {
                displaysNewLine();
                node = search(root, "searches maximum", Integer.MAX_VALUE, searchPath);
                displaysMessage(1, "Maximum: " + node.getsData(), false, false);
            }
            searchPath(searchPath);
        }
        displaysLine();
    }

    private Node search(Node node, String searchOperation, int key, ArrayList <Integer> searchPath) {
        if (node == null) {
            return node;
        }

        searchPath.add(node.getsData());
        
        if (key == node.getsData()) {
            return node;
        } else if (key < node.getsData()) {
            if (node.hasLeftChild()) {
                return search(node.getsLeftChild(), searchOperation, key, searchPath);
            } else {
                if (searchOperation.equals("searches minimum")) {
                    return node;
                }
            }
        } else if (key > node.getsData()) {
            if (node.hasRightChild()) {
                return search(node.getsRightChild(), searchOperation, key, searchPath);
            } else {
                if (searchOperation.equals("searches maximum")) {
                    return node;
                }
            } 
        }

        return null;
    }

    private Node searchMinimum(Node node) {
        if (node == null || !node.hasLeftChild()) {
            return node;
        }
        return searchMinimum(node.getsLeftChild());
    }

    private void searchPath(ArrayList <Integer> searchPath) {
        displaysMessage(1, "\t| Search Path: ", false, false);
        for (int i = 0; i < searchPath.size() - 1; i++) {
            System.out.print(searchPath.get(i) + " ---> ");
        }
        displaysMessage(0, Integer.toString(searchPath.get(searchPath.size() - 1)), false, false);
    }

    private void traversal() {
        displaysMessage(0, "AVL Tree:", true, false);
        displaysMessage(1, " * In-order:\t", false, false);
        traversal(root, "in-order");
        displaysTwoNewLines();
        displaysMessage(1, " * Pre-order:\t", false, false);
        traversal(root, "pre-order");
        displaysTwoNewLines();
        displaysMessage(1, " * Post-order:\t", false, false);
        traversal(root, "post-order");
        displaysNewLine();
        displaysLine();
    }

    private void updatesHeight(Node node, String operation) {
        if (node == null) {
            return;
        } else if (operation.equals("increase")) {
            node.setsHeight(1 + Math.max(getsHeight(node.getsLeftChild()), getsHeight(node.getsRightChild())));
        } else if (operation.equals("updates height of elements in left and right subtrees")) {
            if (node.hasLeftChild()) {
                node.getsLeftChild().setsHeight(node.getsHeight() - 1);
                updatesHeight(node.getsLeftChild(), "updates height of elements in left and right subtrees");
            }
            if (node.hasRightChild()) {
                node.getsRightChild().setsHeight(node.getsHeight() - 1);
                updatesHeight(node.getsRightChild(), "updates height of elements in left and right subtrees");
            }
        }
    }

    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) { 
        AVLTree tree = new AVLTree();
        tree.run();
    } 
} 

class Node { 
    private int data;
    private int height;
    private Node leftChild;
    private Node rightChild; 
  
    public Node(int data) { 
        this.data = data; 
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }
    
    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public int getsData() {
        return this.data;
    }

    public int getsHeight() {
        return this.height;
    }
    
    public Node getsLeftChild() {
        return this.leftChild;
    }

    public Node getsRightChild() {
        return this.rightChild;
    }

    public void setsData(int data) {
        this.data = data;
    }

    public void setsHeight(int height) {
        this.height = height;
    }

    public void setsLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setsRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
} 
