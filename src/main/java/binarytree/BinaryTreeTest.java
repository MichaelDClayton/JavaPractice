package binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(50);
		tree.addNode(25);
		tree.addNode(75);
		tree.addNode(10);
		tree.addNode(60);
		tree.addNode(13);
		tree.addNode(23);
		tree.addNode(30);
		//traverse
		//tree.traverse();

		//search for value.
		int searchValue = 60;
		System.out.println("Search for "+searchValue);
		System.out.println(tree.findNode(searchValue).toString());
	}
	
/*	@Test
	public void test() {
		BinaryTree tree = new BinaryTree();
		tree.addNode(50);
		tree.addNode(25);
		tree.addNode(75);
		tree.addNode(10);
		tree.addNode(60);
		tree.addNode(13);
		tree.addNode(23);
		tree.addNode(30);
		//traverse
		tree.traverse();

	}*/
}
