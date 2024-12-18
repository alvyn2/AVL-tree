package src;
/**
 * @author Julius Bates
 *date created :12/10
 *Node item to makeup each part of Binary Search Tree.
 */
public class Node{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
    
}