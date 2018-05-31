/*
Reverse pairs of elements in a singly-linked list.

Examples

L = null, after reverse is null
L = 1 -> null, after reverse is 1 -> null
L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
*/

/*
  Time:  O( nlog(n) ) 
  Space: O( log(n) )
*/

public class Solution {
  public ListNode reverseInPairs(ListNode head) {
    ListNode prehead = new ListNode(0);
    prehead.next = head;
    ListNode prev = prehead;    // node No.0
    while ( prev.next != null && prev.next.next != null ) {
      ListNode tmp = prev.next;  // node No.1
      prev.next = tmp.next;
      tmp.next = tmp.next.next;
      prev.next.next = tmp;
      prev = tmp;
    }
    return prehead.next;
  }
}
