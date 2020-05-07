public class Solution {
  private Deque<Integer> in;
  private Deque<Integer> out;

  public Solution() {
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  
  public Integer poll() {
    move();
    return out.isEmpty() ? null : out.pollFirst();
  }
  
  public void offer(int element) {
    in.offerFirst(element);
  }
  
  public Integer peek() {
    move();
    return out.isEmpty() ? null : out.peekFirst();
  }

  private void move() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerFirst(in.pollFirst());
      }
    }
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }
}




// My Solution
public class Solution {
  Stack stack;
  Stack temp;
  public Solution() {
    stack = new Stack<>();
    temp = new Stack<>();
  }
  
  public Integer poll() {
    if (stack.isEmpty()) {
      return null;
    }

    return (int)stack.pop();
  }
  
  public void offer(int element) {
    if (stack.isEmpty()) {
      stack.push(element);
    } else {
      while(!stack.isEmpty()) {
        temp.push(stack.pop());
      }
      stack.push(element);
      while(!temp.isEmpty()) {
        stack.push(temp.pop());
      }
    } 
  }
  
  public Integer peek() {
    if (stack.isEmpty()) {
      return null;
    }

    return (int)stack.peek();
  }
  
  public int size() {
    return stack.size();
  }
  
  public boolean isEmpty() {
    return stack.isEmpty();
  }
}
