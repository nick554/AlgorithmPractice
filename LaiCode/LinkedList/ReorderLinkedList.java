/*
Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> бн -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> бн -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
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
  public ListNode reorder(ListNode head) {
    // corner case: length == 0 or 1
    if (head == null || head.next == null) return head;
    
    // find the midpoint( left can be longer than right ), mid is the end of left part
    ListNode mid = findMid( head );
    ListNode left = head;
    ListNode right = mid.next;
    mid.next = null;
    
    // reverse the right part
    right = reverse( right );
    
    // combine two part
    return merge(left, right);
  }
  private ListNode findMid(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
  private ListNode reverse(ListNode head) {
    ListNode result = null;
    
    while (head != null) {
      ListNode tmp = head.next;
      head.next = result;
      result = head;
      head = tmp;
    }
    
    return result;
  }
  private ListNode merge(ListNode left, ListNode right) {
    ListNode result = left;
    ListNode current = result;
    
    left = left.next;
    
    while (right != null) {
      current.next = right;
      current = right;
      right = right.next;
      if (left != null) {
      	current.next = left;
      	current = left;
      	left = left.next;
      }
    }
        
    return result;
  }
}