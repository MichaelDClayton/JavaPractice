package binarytree;

public class Node {

    public int val;
    public Node leftChild;
    public Node rightChild;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public String toString() {
        return "My Node value is " + val;
    }
}
