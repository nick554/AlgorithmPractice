/*
Given two nodes in a binary tree, find their lowest common ancestor.

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9
*/

/*
  Time:  O( n ) 
  Space: O( logn )
*/

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // base case
    if ( root == null ) {
      return null;
    }
    
    // recursion rule
    if ( root == one || root == two ) {
      return root;
    } else {
      TreeNode left = lowestCommonAncestor( root.left, one, two );
      TreeNode right = lowestCommonAncestor( root.right, one, two );
      if ( left != null && right != null ) {
        return root;
      } else if ( left != null ) {
        return left;
      } else {
        return right;  // right != null or left & right == null
      }
    }
  }
}