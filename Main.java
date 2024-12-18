

/**
 * @author Julius Bates
 *date created :12/11
 *Testing
 */
public class Main {


	public static void main(String[] args) {
		// Tests binary search tree
		BST tree=new BST();
		tree.insert(3);
		tree.insert(1);
		tree.insert(2);
		
		tree.insert(4);
	//	tree.insert(5);

		//tree.insert(40);
		//tree.remove(1);
		System.out.println(tree.toString());
	}

}
