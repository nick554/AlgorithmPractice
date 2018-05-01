/*
Implement an iterative, pre-order traversal of a given binary tree, return the list of keys of each node in the tree as it is pre-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]
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
  // assumption: for root == null, return empty list/ can use Linkedlist as output
  public List<Integer> preOrder(TreeNode root) {
    // initialize result (use linkedlist for frequent changed size)
    List< Integer > result = new LinkedList< Integer >();
    // use a stack to store the unfinished node
    Deque< TreeNode > Stack = new LinkedList< TreeNode >();
    
    Stack.offerLast( root );
    while (Stack.size() > 0) {
      TreeNode Current = Stack.pollLast();
      
      if (Current == null) continue;
      
      result.add( Current.key );
      Stack.offerLast( Current.right );
      Stack.offerLast( Current.left );
    }
    
    return result;
  }
}