
public class Linked_lists {
	Linked_lists() { }
	
	public void run() {
		
	}
	
	/*
	You have two numbers represented by a linked list, where each node contains a single digit.
	The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
	Write a function that adds the two numbers and returns the sum as a linked list.
	EXAMPLE
	Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
	Output: 8 -> 0 -> 8
	 */
	LN addList(LN node1, LN node2, int carry) {
		if(node1 == null && node2 == null) {
			return null;
		}
		int value = carry;
		LN result = new LN(0);
		if(node1 != null ) {
			value += node1.getValue();
		}
		if(node2 != null) {
			value += node2.getValue();
		}
		result.setValue(value % 9);
		LN more = addList(node1.getNext(), node2.getNext(), value > 9 ? 1 : 0);
		result.setNext(more);
		return result;
	}
}
