package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * author : leo
 * date : 2014-5-19
 * comment : 
 * 体会4种点不同的作用
 */
public class LongestValidParentheses {

	public static void main(String[] args) {

		String s = "()(()()";

		int result = longestValidParentheses(s);

		System.out.println(result);
	}

	public static int longestValidParentheses(String s) {

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int last = -1;
		int max = 0;
		char ch;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - last);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}

		return max;
	}
}
