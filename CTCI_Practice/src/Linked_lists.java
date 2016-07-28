
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
	private LN addList(LN node1, LN node2, int carry) {
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
	 
	// Implement an algorithm to find the n-th last element of a singly linked list
	// Simple solution using 1 pointer to the head of the list
	private LN nthToLast(LN list, int index) {
		int len = 0;
		LN head = list;
		while(list.getNext() != null) {
			len++;
			head = list.getNext();
		}
		int nth = len - index - 1; // -1 for 0 offset
		head = list;
		for(int i = 0; i < nth; i++) {
			head = list.getNext();
		}
		return head;
	}
	
	// Better solution utilizing the space between two pointers.
	private LN nthToLast2(LN list, int index) {
		if(list == null || index < 1) {
			return null;
		}
		LN p1 = list;
		LN p2 = list;
		for(int i = 0; i < index - 1; i++) {
			if(p2.getNext() == null) {
				return null;
			}
			p2 = p2.getNext();
		}
		while(p2 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		return p1;
	}
	
	
	
}
