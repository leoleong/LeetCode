/**
 * Problem:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 	- push(x) -- Push element x onto stack.
 * 	- pop() -- Removes the element on top of the stack.
 * 	- top() -- Get the top element.
 * 	- getMin() -- Retrieve the minimum element in the stack.
 */
package stack;

import java.util.ArrayList;

public class MinStack {

	ArrayList<Integer> numStack = new ArrayList<Integer>();
	ArrayList<Integer> minStack = new ArrayList<Integer>();

	public void push(int x) {
		numStack.add(x);
		if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x) {
			minStack.add(x);
		}
	}

	public void pop() {
		if (numStack.isEmpty()) {
			return;
		}
		
		int top = numStack.remove(numStack.size() - 1);
		if (!minStack.isEmpty() && top == minStack.get(minStack.size() - 1)) {
			minStack.remove(minStack.size() - 1);
		}
	}

	public int top() {
		if (!numStack.isEmpty()) {
			return numStack.get(numStack.size() - 1);
		}

		return 0;
	}

	public int getMin() {
		if (!minStack.isEmpty()){
			return minStack.get(minStack.size() - 1);
		}
		
		return 0;
	}
}
