package binarytree;

public class Node {

    public int val;
    public Node leftChild;
    public Node rightChild;

    /*
    root = 9
        left = 4,               right 3
    left -2                 left = 1 right = 6

    //9, 4, 3, 2, 1, 6

    root = 9;
    root.left = 4,
    methodCall(root = 9)
    if(root.left !=null)
        pass root.left back to methodCall
    )
    if(root.right != null){
     pass root.root back to methodCall
     */
    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public String toString() {
        return "My Node value is " + val;
    }
}
