

/**
 * @author Julius Bates
 *date created :12/11
 *Testing for BST and AVL tree
 */
public class Main {


	public static void main(String[] args) {
		// Tests binary search tree
		BST tree=new BST();
		tree.insert(4);
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
	//	tree.insert(5);
	//	tree.insert(6);
	//	tree.insert(7);
		System.out.print(tree.toString());
		tree.printTree();
	
	}

}
