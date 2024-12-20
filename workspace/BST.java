

import java.util.*;
/**
 * @author Julius Bates
 *date created :12/10
 *Binary Search Tree
 */
public class BST {
	Node root=null;
	
	
    public BST()
    {
         root = null;
    }

    
  //precondition:  function is called and key is a valid and non-null integer
  //postcondition: a new node is added to the tree with the key inputted and in the right location
    
    void insert(int key){
    	Node current=root;
    	if(root==null) {
    		root=new Node(key);
    		return;
    	}
    	while(key <= current.key) {
    		if(current.left==null) {
    			current.left=new Node(key);
    			return;
    		}else {
    			current=current.left;
    		}
    	}

    	while(key>current.key) {
    		if(current.right==null) {
    			current.right=new Node(key);
    			return;
    		}else {
    			current=current.right;
    		}
    	}

		while(key <= current.key) {
    		if(current.left==null) {
    			current.left=new Node(key);
    			return;
    		}else {
    			current=current.left;
    		}
    	}
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
    //precondition:key is a falid int and root is not null    
    //postcondition:node is removed from the tree
    int remove(int key){
    	Node last=null;
    	Node current=root;
    	Node replace=null;
    	int out=-1;
    	if(root==null) {
    		return -1;
    	}
    	while(key <= current.key) {
    		if(current.left==null) {
    			//return -1;
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
    			return key;
    		}else {
    			last=current;
    			current=current.left;
    		}
    	}
    	while(key>=current.key) {
    		if(current.right==null) {
    			
    		}else if(current.key==key){
    			return key;
    		}else {
    			current=current.left;
    		}
    	}

    	
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
          trunk.str = "���";
      }
      else if (isLeft) {
          trunk.str = ".���";
          prev_str = "   |";
      }
      else {
          trunk.str = "`���";
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
