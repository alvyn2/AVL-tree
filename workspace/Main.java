

/**
 * @author Julius Bates
 *date created :12/11
 *Testing
 */
public class Main {


	public static void main(String[] args) {
		// Tests binary search tree
		BST tree=new BST();
	tree.insert(5);
	tree.insert(4);
	tree.insert(3);
	tree.insert(2);
	tree.insert(1);
	tree.insert(6);
	tree.insert(7);
	tree.insert(8);
	tree.insert(9);
	tree.insert(10);
		//tree.insert(40);
		//tree.remove(1);
		//System.out.println(tree.toString());
		System.out.println(tree.isBSTOrNot());
	}

}
