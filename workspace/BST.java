

import java.util.*;
/**
 * @author Julius Bates
 *date created :12/10
 *Binary Search Tree
 */
public class BST {
	Node root=null;
	ArrayList<Node> path=new ArrayList<Node>();
	
    public BST()
    {
         root = null;
    }

    
  //precondition:  function is called and key is a valid and non-null integer
  //postcondition: a new node is added to the tree with the key inputted and in the right location also rebalances the tree if it becomes unbalanced
    
    void insert(int key){
    	Node current=root;
		boolean placed=false;
		Node in=new Node(key);
    	path.clear();
		if(current==null) {
    		root=in;
			placed=true;
			path.add(current);
			
    	}
		while(placed==false && current !=null){
    	while(current !=null && key <= current.key) {
    		if(current.left==null) {
    			current.left=in;
    			placed=true;
				path.add(current);
				current=null;
    		}else {
				path.add(current);
    			current=current.left;
    		}
    	}

    	while(current !=null && key>current.key) {
    		if(current.right==null) {
    			current.right=in;
    			placed=true;
				path.add(current);
				current=null;
    		}else {
				path.add(current);
    			current=current.right;
    		}
    	}
	
			
		}
		
		for(int i=0;i<path.size()-1;i++){
			System.out.println(path.get(i).key);
			Node next=path.get(i+1);
			Node n=path.get(i);
			System.out.println("balance = "+this.balance(n));
			System.out.println("cbalance = "+this.checkBalance(n));
			if(this.balance(next)>=2){

				if(this.balance(next.right)>=0){
					this.leftRotate(next,n);
					System.out.println("left");
				}else{
					this.rightRotate(next.right,next);
					this.leftRotate(next,n);
					System.out.println("d left");
				}
			}else if(this.balance(next)<=-2){

				if(this.balance(next.left)<=0){
					this.rightRotate(next, n);
					System.out.println("right");
				}else{
					this.leftRotate(next.left,next);
					this.rightRotate(next, n);
					System.out.println(" d right");
				}
			}
			next=n;
		}

		path.clear();


	}
    
    //precondition: function is called    
    //postcondition: returns true if there is a node with the key, false if there is no node with the same value as key in the tree
    boolean search(int key){
    	boolean found=false;
    	if(root==null) {
    		return false;
    	}
    	Node current=root;
    	while(key <= current.key) {
    		if(current.left==null) {
    			found=false;
    			return found;
    		}else if(current.key==key){
    			found=true;
    			return found;
    		}else {
    			current=current.left;
    		}
    	}
    	while(key>=current.key) {
    		if(current.right==null) {
    			found=false;
    			return found;
    		}else if(current.key==key){
    			found=true;
    			return found;
    		}else {
    			current=current.left;
    		}
    	}
    	
    	
    	return found;
    }
    //precondition:key is a valid int and root is not null    
    //postcondition:node is removed from the tree
    int remove(int key){
    	Node last=root;
    	Node current=root;
    	Node replace=null;
    	int out=-1;
		path.clear();
    	if(root==null) {
    		return out;
    	}else if(root.key==key){
			if(root.left!=null){
				path.add(current);
				current=root.left;
			while(current.right!=null){
				path.add(current);
				current=current.right;
			}
			root.key=current.key;
			root.left=current.left;
			
		}
			out= key;
		}
    	while(key <= current.key) {
    		if(current.left==null) {
    			return -1;
    		}else if(current.key==key){
    			out=key;
    			if(current.left.left==null || current.left.right == null) {
    				last.left=current.left;
    			}else if(current.left.left==null && current.left.right == null) {
    				last.left=null;
    			}else {
    				Node c=current.left.right;
    				while(c.left != null) {
    					last=c;
    					c=c.left;
    					
    				}
    				replace=c;
    				current.key=replace.key;
    				last.left=null;
    				
    			}
    			out= key;
    		}else {
    			last=current;
    			current=current.left;
    		}
    	}
    	while(key>=current.key) {
    		if(current.right==null) {
    			return -1;
    		}else if(current.key==key){
    			return key;
    		}else {
				path.add(current);
    			current=current.right;
    		}
    	}

    	for(int i=0;i<path.size()-1;i++){
			System.out.println(path.get(i).key);
			Node next=path.get(i+1);
			Node n=path.get(i);
			System.out.println("balance = "+this.balance(n));
			System.out.println("cbalance = "+this.checkBalance(n));
			if(this.balance(next)>=2){

				if(this.balance(next.right)>=0){
					this.leftRotate(next,n);
					System.out.println("left");
				}else{
					this.rightRotate(next.right,next);
					this.leftRotate(next,n);
					System.out.println("d left");
				}
			}else if(this.balance(next)<=-2){

				if(this.balance(next.left)<=0){
					this.rightRotate(next, n);
					System.out.println("right");
				}else{
					this.leftRotate(next.left,next);
					this.rightRotate(next, n);
					System.out.println(" d right");
				}
			}
			next=n;
		}

		path.clear();

    	return out;
    }

    
    //precondition: the root of the tree is non-null
    //postcondition: returns the binary search tree converted to a string with a new line for each depth
    public String toString(){
    	String out="";
    	ArrayList<ArrayList<Integer>> converted=stringHelper(root, new ArrayList<ArrayList<Integer>>() , 0);
		
    	//prints the arrayList
    	for(ArrayList<Integer> list : converted) {
			for(Integer i : list) {
				out+=i.toString()+ " ";
			}
			out+="\n";
		}

    	return out;
        
    }
    //precondition:   the root is non-null and r is an empty nested arraylist
    //postcondition: returns an arraylist containing the jey of each node in different arraylists based on the depth in the tree
    public ArrayList<ArrayList<Integer>> stringHelper(Node curr, ArrayList<ArrayList<Integer>> r, int depth){
    	//System.out.println("stringHelper called on "+ curr.key);
		
    	Integer current=null;
    	ArrayList<Integer> level=new ArrayList<Integer>();
    	if(depth==0){// at head
    		//gets root which is the only node in the top depth
    	//level=new ArrayList<Integer>();
    	current=root.key;
    	level.add(current);
    	r.add(depth,level);
    	//System.out.println("root level added");
    	return stringHelper(root,r,1);
		}else {
			if(curr.left==null && curr.right==null) {// base case
				return r;
			}else {
				//for(int i=1;i<=depth;i++) {
				level.clear();
				if(depth>=r.size()){
				r.add(depth,level);
				}
				//System.out.println("stringhelper called, added new level");
				if(curr.left != null) {
					current=curr.left.key;
					r.get(depth).add(current);
					r=stringHelper(curr.left,r,depth+1);
				}
				if(curr.right != null) {
					current=curr.right.key;
					r.get(depth).add(current);
					r=stringHelper(curr.right,r,depth+1);
				}
			
				//}
				//level=stringHelperHelper(curr,level,depth);

				//r.add(depth, level);
				/*
				if(depth>r.size()-1){
				level.clear();
				r.add(depth,level);
				System.out.println("another level added");
				}
				*/
				/*for(int i=0;i<=depth;i++) {

				if(curr.left != null) {
					if(i==depth){
						current=last.left.key;
					r.get(depth).add(current);
					}else{
						last=last.left;
					}
	    			//r= stringHelper(curr.left,r,depth+1);
				}
			}*/
			//last=root;
			/*for(int i=0;i<=depth;i++) {
	    		if(last.right != null) {
	    			if(i==depth){
						current=curr.right.key;
					r.get(depth).add(current);
					}else{
						last=last.right;
					}
	    			//r=stringHelper(curr.right, r,depth+1);
	    		}
	    		//curr=last;
				}
			}*/
			/* 
    		if(curr.left != null) {
    			current=curr.left.key;
    			level.add(current);
        		//r=stringHelper(curr.left,r,depth+1);
    		}
    		if(curr.right != null) {
    			current=curr.right.key;
    			level.add(current);
    			
    			//r= stringHelper(curr.right, r,depth+1);
    		}
    		*/
    
    		/*if(curr.left != null) {
    			r=stringHelper(curr.left,r,depth+1);
    		}
    		if(curr.right != null) {
    			r= stringHelper(curr.right, r,depth+1);
    		}
    		*/
    		//r.add(level);
    		return r;
			}
    		//return r;
    		//return stringHelper(curr.right, r,depth+1);
    	}
	
    	
    	//return r;
    }
//
// rotates the left child to top
public void rightRotate(Node subRoot,Node prev){
	Node temp=subRoot.left;
	//System.out.println("temp = "+ temp.key);
	//Node temp2=subRoot.right;
	//subRoot=subRoot.left;
	subRoot.left=subRoot.left.right;//step 1
	temp.right=subRoot;
	if(prev == null){
		this.root=temp;
	}if(prev.right!=null && prev.right==subRoot){
		prev.right=temp;
	}else if(prev.left!=null && prev.left==subRoot){
		prev.left=temp;
	}
	
	//System.out.println("ended");
	//temp.left=temp2;
}
//
//rotates the tree to the left
//precondition
//
public void leftRotate(Node subRoot,Node prev){
	Node temp=subRoot.right;
	//System.out.println("temp = "+ temp.key);

	subRoot.right=subRoot.right.left;//step 1
	temp.left=subRoot;
	if(prev == null){
		this.root=temp;
	}if(prev.right!=null && prev.right==subRoot){
		prev.right=temp;
	}else if(prev.left!=null && prev.left==subRoot){
		prev.left=temp;
	}
}


//precondition:
// returns the height of the node 
private int height(Node node){
	if(node==null){
		return 0;
	}
	Node c=node;
	int r=0;
	int l=0;
	int h=1;
	if(c.right!=null){
		r=height(c.right);

	}
	if(c.left != null){
		l=height(c.left);
	}
	if(l>r){
		h+=l;
	}else{
		h+=r;
	}
	//System.out.println("n"+node.key+"height="+h);
	return h;
}
//
//returns the balance at the specified node

private int balance(Node node){
	
	int b=0;
	int r;
	int l;
	if(node.left!=null){
	l=height(node.left);
	}else{
		l=0;
	}
	if(node.right!=null){
	r=height(node.right);
	}else{
		r=0;
	}

	b=r-l;
	System.out.println("node:"+ node.key+ "balance: " +b);
	return b;
}

public int checkBalance(Node curr){// not used 
	int balance=0;
	if(curr==null){
		return 0;
	}else if(curr.left==null && curr.right==null){
		balance++;// to make balance one if curr is a leaf
		return balance;

	}else if(curr.left !=null){
		balance-=checkBalance(curr.left);
		balance--;
	}else if(curr.right !=null){
		balance+=checkBalance(curr.right);
		balance++;
	}else{
		return balance - checkBalance(curr.left) + checkBalance(curr.right);
	}

		return balance;



}
//new code
//Add the following functions to your BST
//Please use this code to verify your tree integrity
  public boolean isBSTOrNot() {
      return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
      // check for root is not null or not
      if (root == null) {
          return true;
      }
      // check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
      if(root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key) && isBSTOrNot(root.right, root.key, maxValue)){
          return true;
      }
      return false;
  }




 // please use the following pieces of code to display your tree in a more easy to follow style (Note* you'll need to place the Trunk class in it's own file)
  public static void showTrunks(Trunk p)
  {
      if (p == null) {
          return;
      }

      showTrunks(p.prev);
      System.out.print(p.str);
  }

  public void printTree(){
      printTree(root, null, false);
  }

  private void printTree(Node root, Trunk prev, boolean isLeft)
  {
      if (root == null) {
          return;
      }

      String prev_str = "    ";
      Trunk trunk = new Trunk(prev, prev_str);

      printTree(root.right, trunk, true);

      if (prev == null) {
          trunk.str = "___";
      }
      else if (isLeft) {
          trunk.str = ".___";
          prev_str = "   |";
      }
      else {
          trunk.str = "`___";
          prev.str = prev_str;
      }

      showTrunks(trunk);
      System.out.println(" " + root.key);

      if (prev != null) {
          prev.str = prev_str;
      }
      trunk.str = "   |";

      printTree(root.left, trunk, false);
  }



  
}
