/*
Reverse a singly-linked list.

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
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
  public ListNode reverse(ListNode head) {
    //corner case (head == null) included
    ListNode preHead = new ListNode(0);
    while (head != null) {
      ListNode tmp = head.next;
      head.next = preHead.next;
      preHead.next = head;
      head = tmp;
    }
    return preHead.next;
  }
}