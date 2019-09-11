/*
 * StackImpl class
 * This class defines an implementation
 * of a Stack using linked lists
 * 
 * Using a linked list as the underlying data structure
 * allows push(), pop(), and peek() to all be performed
 * in O(1) time.
 * 
 * author: Connor Brewton
 * date created: 9/11/2019
 */
public class StackImpl<T> {

	// Members
	private Node top;	// top of stack
	private int size;	// num elements in stack
	
	private class Node {
		private T ele;
		private Node next;	// points to element below this one
		
		public Node(T ele) {
			this.ele = ele;
		}
	}
	
	/*
	 * Constructor - does nothing
	 */
	public StackImpl() {
		
	}
	
	/*
	 * push()
	 * adds an element to the top of the stack
	 */
	public StackImpl<T> push(T ele) {
		Node oldTop = top;
		top = new Node(ele);
		top.next = oldTop;
		size++;
		
		return this;
	}
	
	/*
	 * pop()
	 * removes and returns the top element from the stack
	 */
	public T pop() {
		T ele = top.ele;
		top = top.next;
		size--;
		
		return ele;
	}
	
	/*
	 * returns the top element from the stack but does not remove
	 */
	public T peek() {
		T ele = top.ele;
		return ele;
	}
	
	/*
	 * size()
	 * returns the number of elements in the stack
	 */
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		String str = "";
		Node current = top;
		while (current != null) {
			str = str + current.ele;
			current = current.next;
		}
		return str;
	}
	
	public static void main(String[] args) {
		
		StackImpl<Integer> s = new StackImpl<Integer>();
		for (int i=0; i<5; i++) {
			System.out.println("Pushing " + i + " onto stack...");
			s.push(i);
		}
		System.out.println("Size: " + s.size());
		System.out.println("Stack string: " + s.toString());
		System.out.println("Top: " + s.peek());
		System.out.println("Popping element: " + s.pop());
		System.out.println("Popping element: " + s.pop());
		System.out.println("Popping element: " + s.pop());
		System.out.println("Size: " + s.size());
	}
}
