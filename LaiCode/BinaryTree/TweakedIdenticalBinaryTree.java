/*
Determine whether two given binary trees are identical assuming any number of ¡®tweak¡¯s are allowed. A tweak is defined as a swap of the children of one node in the tree.

Examples                  and

        5                               5

      /    \                          /    \

    3        8                      8        3

  /   \                                    /   \

1      4                                  1     4
the two binary trees are tweaked identical.
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
  // assumption: r1 == r2 == null => return true
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // base case:
    if (one == null || two == null) {
      if (two == null && one == null) {
        return true;
      }
      return false;
    }
    
    // recursion rule:
    if (one.key == two.key) {
      // examine next level
      if (isTweakedIdentical(one.left, two.left) ) {
        return isTweakedIdentical(one.right, two.right);
      } else if (isTweakedIdentical(one.left, two.right) ) {
        return isTweakedIdentical(one.right, two.left);
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}