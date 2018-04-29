/*
Merge two sorted lists into one large sorted list.

Examples

L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
L1 = null, L2 = null, merge L1 and L2 to null
*/

/*
  Time:  O( n ) 
  Space: O( 1 )
*/

/*
 class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
  }
*/

public class Solution {
  // assumption: both list can be null/ have duplicate value
  public ListNode merge(ListNode one, ListNode two) {
    // base case
    if (one == null) return two;
    if (two == null) return one;
    
    if (one.value <= two.value) {
      one.next = merge(two, one.next);
      return one;
    } else {
      two.next = merge(one, two.next);
      return two;
    }
  }
}