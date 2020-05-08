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
  public ListNode merge(ListNode one, ListNode two) {
    ListNode dummyNode = new ListNode(0);
    ListNode p = dummyNode;
    
    while (one != null && two != null) {
      if (one.value <= two.value) {
          p.next = one;
          one = one.next;
      } else {
          p.next = two;
          two = two.next;
      }
      
      p = p.next;    
    }
    
    if (one != null) {
      p.next = one;
    }
    
    if (two != null) {
      p.next = two;
    }
    
    return dummyNode.next;
  }
}
