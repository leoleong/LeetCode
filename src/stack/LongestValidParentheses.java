/**
 * Problem:
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

	public static void main(String[] args) {

		String s = "()(()()";
		int result = longestValidParentheses(s);
		System.out.println(result);
	}

	public static int longestValidParentheses(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int start = 0;
		int max = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					start = i + 1;
				} else {
					stack.pop();
					max = stack.isEmpty() ? Math.max(max, i - start + 1) : Math
							.max(max, i - stack.peek());
				}
			}
		}

		return max;
	}
}
