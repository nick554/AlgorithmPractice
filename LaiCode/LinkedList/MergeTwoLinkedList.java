/*
Merge two sorted lists into one large sorted list.

Examples

L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
L1 = null, L2 = null, merge L1 and L2 to null
*/

/*
  Time:  O( n ) 
  Space: recursion: O( n )  iteration: O( 1 )
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

// recursive solution
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

// iterative solution
public class Solution {
  // assumption: both list can be null/ have duplicate value
  public ListNode merge(ListNode one, ListNode two) {
    // prehead to record the reference of the head
    ListNode preHead = new ListNode(0);
    ListNode current = preHead;
    
    while (one != null && two != null) {
      if ( one.value <= two.value ) {
        current.next = one;
        current = one;
        one = one.next;
      } else {
        current.next = two;
        current = two;
        two = two.next;
      }
    }
    
    if (one == null) {
      current.next = two;
    } else {
      current.next = one;
    }
    
    return preHead.next;
  }
}