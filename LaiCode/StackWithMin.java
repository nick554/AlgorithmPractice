/*
Enhance the stack implementation to support min() operation. 

pop() - remove and return the top element, if the stack is empty, return -1
push(int element) - push the element to top
top() - return the top element without remove it. If the stack is empty, return -1
min() - return the current min value in the stack. If the stack is empty, return -1
*/

public class Solution {
  private int size;
  // one stack to store the sequence(entrance at right)
  private Deque<Integer> Stack;
  // another stack to store the min information(entrance at right)
  private Deque<Pair> MinStack;

  public Solution() {
    Stack = new LinkedList<Integer>();
    MinStack = new LinkedList<Pair>();
    size = 0;
  }

  public int pop() {
    if ( size == 0 ) return -1;
    
    size--;
    if ( MinStack.peekLast().getIndex() == size ) MinStack.pollLast();
    
    return Stack.pollLast();
  }
  
  public void push(int element) {
    Stack.offerLast( element );
    if (size == 0 || MinStack.peekLast().getMin() > element) {
      MinStack.offerLast( new Pair(size, element) );
    }
    size++;
  }
  
  public int top() {
    if (size == 0 ) return -1;
    
    return Stack.peekLast();
  }
  
  public int min() {
    if (size == 0 ) return -1;

    return MinStack.peekLast().getMin();
  }
  
  //class Pair
  private class Pair{
    private int index;
    private int min;
    
    Pair(int a, int b) {
      index = a;
      min = b;
    }
    
    int getIndex() {
      return index;
    }
    int getMin() {
      return min;
    }
  }
}

