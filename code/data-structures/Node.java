public class Node {
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
