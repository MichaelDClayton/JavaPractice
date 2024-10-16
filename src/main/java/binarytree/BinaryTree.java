package binarytree;

public class BinaryTree {

	binarytree.Node root;

	public BinaryTree() {
		
	}

	public Node findNode(int data){
		Node nodeToSearchFor = root;
		while(nodeToSearchFor.val != data){
			if(data < nodeToSearchFor.val){
				nodeToSearchFor = nodeToSearchFor.leftChild;
			}else{
				nodeToSearchFor = nodeToSearchFor.rightChild;
			}
		}

        return nodeToSearchFor;
	}

	public int getTreeHeight(binarytree.Node root) {
		if(root == null)
			return -1;
		
		int left = getTreeHeight(root.leftChild);
		int right = getTreeHeight(root.rightChild);
		
		if(left > right) {
			return left + 1;
		}else {
			return right + 1;
		}
		
	}
	
	public void addNode(int val) {
		binarytree.Node nodeToAdd = new binarytree.Node(val);
		
		if(root == null) {
			root = nodeToAdd;
			return;
		}
		
		
		traverseThenAdd(root, nodeToAdd);
		
		
	}
	

	private void traverseThenAdd(Node node, Node nodeToAdd) {
		
		if(nodeToAdd.val < node.val) {
			if(node.leftChild == null) {
				node.leftChild = nodeToAdd;
			}else {
				traverseThenAdd(node.leftChild,nodeToAdd);
			}
			
		}else if(nodeToAdd.val > node.val) {
			if(node.rightChild == null) {
				node.rightChild = nodeToAdd;
			}else {
				traverseThenAdd(node.rightChild,nodeToAdd);
			}
			
		}
	}
	
	
	
	public void traverse() {
	
		if(root != null) {
			Node nodeToTraverse = root;
			System.out.println("Pre-Order");
			preOrder(nodeToTraverse);
			System.out.println("------------------");
			System.out.println("Post-Order");
			postOrder(nodeToTraverse);
			System.out.println("------------------");
			System.out.println("In-Order");
			inOrder(nodeToTraverse);
		}
		
	}
	
	private void preOrder(Node node) {
		if(node == null) 
			return;
		System.out.println(node.val);
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}
	
	private void postOrder(Node node) {
		if(node == null) 		
			return;
		postOrder(node.leftChild);
		postOrder(node.rightChild);
		System.out.println(node.val);
		
	}
	
	private void inOrder(Node node) {
		if(node == null)
			return;
		inOrder(node.leftChild);
		System.out.println(node.val);
		inOrder(node.rightChild);
	}
}
