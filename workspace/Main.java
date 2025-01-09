

/**
 * @author Julius Bates
 *date created :12/11
 *Testing for BST and AVL tree
 */
public class Main {


	public static void main(String[] args) {
		// Tests binary search tree
		BST tree=new BST();
		tree.insert(50);
		tree.insert(10);
		tree.insert(100);
		tree.insert(30);
		tree.insert(40);
		tree.insert(20);
		tree.insert(80);
		tree.insert(70);
		tree.insert(60);

		tree.insert(90);
		tree.insert(65);
		tree.insert(81);
		tree.insert(73);
		tree.insert(61);
		
		tree.insert(18);
		tree.insert(25);
		tree.insert(31);
		tree.insert(43);
		tree.insert(51);
		System.out.print(tree.toString());
		tree.printTree();
	}

}
