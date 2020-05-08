/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode reorder(ListNode head) {
    if(head == null || head.next == null)
      return head;
    
    // 1.find the middle node
    ListNode mid = middleNode(head);
    ListNode head1 = head;
    ListNode head2 = mid.next;
    // de-link the second half from the list.
    mid.next = null;
    // 2. reverse the second half
    // 3. merge the two halves
    return merge(head1, reverse(head2));
  }

  private ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    
    while(fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      
      ListNode prev = null;
      while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
      }
      
      return prev;
  }
    
  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(0);
    ListNode p = dummyNode;
    
    while(l1 != null && l2 != null) {
        p.next = l1;
        l1 = l1.next;
        p = p.next;
        
        p.next = l2;
        l2 = l2.next;
        p = p.next;
    }
    
    if(l1 != null) {
      p.next = l1;
    }

    if(l2 != null) {
      p.next = l2;
    }

    return dummyNode.next;
  }
}
