/*
Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]
*/

/*
  Time:  O( n ) 
  Space: O( n )
*/

/*
 public class TreeNode {
   public int key;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int key) {
     this.key = key;
   }
 }
*/

public class Solution {
  //assumption: can use LinkedList as output/ for root == null, return empty list
  public List<Integer> inOrder(TreeNode root) {
    // initialize result (use LinkedList because we change the size very often)
    List< Integer > result = new LinkedList< Integer >();
    // used a stack to store the node haven't been processed
    Deque< TreeNode > Stack = new LinkedList< TreeNode >();
    
    while ( true ) {
      while (root != null) {
      	Stack.offerLast( root );
      	root = root.left;
    	}
      if (Stack.size() == 0) {
        break;
      }
      root = Stack.pollLast();
      result.add( root.key );
      root = root.right;
    }
    
    return result;
  }
}
