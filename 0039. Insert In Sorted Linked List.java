// without dummyNode
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
  public ListNode insert(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    if (head == null || head.value >= value) {
      newNode.next = head;
      return newNode;
    }

    ListNode prev = head;
    while (prev.next != null && prev.next.value < value) {
      prev = prev.next;
    }

    newNode.next = prev.next;
    prev.next = newNode;

    return head;
  }
}


// with dummyNode
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
  public ListNode insert(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      return newNode;
    }

    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;
    ListNode prev = dummyNode;
    while (prev.next != null && prev.next.value < value) {
      prev = prev.next;
    }

    ListNode temp = prev.next;
    prev.next = newNode;
    newNode.next = temp;

    return dummyNode.next;
  }
}
