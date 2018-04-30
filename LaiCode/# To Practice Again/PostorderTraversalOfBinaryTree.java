/*
Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]
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
  // assumption£ºcan use linkedist as output/ return empty list while root == null
  public List<Integer> postOrder(TreeNode root) {
    // initialize result
    List< Integer > result = new LinkedList< Integer >();
    if (root == null) return result;
    // used a stack to store the unfinished node
    Deque< TreeNode > Stack = new LinkedList< TreeNode >();
    
    Stack.offerLast( root );
    TreeNode LastNode = null; // LastNode: the last node we dealt with 
    													// (null means at start; we never put a null into this stack)
    
    while (Stack.size() != 0) {
      TreeNode Curr = Stack.peekLast();
      
      if (LastNode == Curr.left || Curr.left == null) {
        // left subtree done!
        if (Curr.right != null && LastNode != Curr.right) {
        	// expand right subtree
        	Stack.offerLast( Curr.right );
        } else {
          // both subtree done! process current node
          result.add( Curr.key );
          Stack.pollLast();
        }
      } else if (LastNode == null || LastNode != Curr.right) {
        // left subtree not done!
        Stack.offerLast( Curr.left );
      } else {
        // both subtree done! or no subtree! process current node
        result.add( Curr.key );
        Stack.pollLast();
      }
      LastNode = Curr;
    }
    
    return result;
  }
}