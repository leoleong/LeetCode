/**
 * Problem:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

	public static void main(String[] args) {

		String s = "(){}()[]";
		boolean result = isValid(s);
		System.out.println(result);
	}

	private static boolean isValid(String s) {

		String left = "([{";
		String right = ")]}";
		Deque<Integer> stack = new ArrayDeque<Integer>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int idx = left.indexOf(ch);

			if (idx != -1) {
				stack.push(idx);
			} else {
				idx = right.indexOf(ch);
				if (stack.isEmpty() || stack.pop() != idx) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
