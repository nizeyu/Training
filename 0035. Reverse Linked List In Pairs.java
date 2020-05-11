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
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode n1 = head;
    ListNode newHead = head.next;

    while (n1 != null && n1.next != null) {
      ListNode n2 = n1.next;
      ListNode n3 = n2.next;

      n2.next = n1;
      if (n3 == null) {
        n1.next = null;
      } else {
        ListNode n4 = n3.next;
        if (n4 == null) {
          n1.next = n3;
        } else {
          n1.next = n4;
        }
      }
      n1 = n3;
    }
    
    return newHead;
  }
}


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
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = head.next;
    head.next = reverseInPairs(head.next.next);
    newHead.next = head;
    return newHead;
  }
}

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
  public ListNode reverseInPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode cur = dummy;

    while (cur.next != null && cur.next.next != null) {
      ListNode next = cur.next.next;
      cur.next.next = cur.next.next.next;
      next.next = cur.next;
      cur.next = next;
      cur = cur.next.next;
    }
    
    return dummy.next;
  }
}
