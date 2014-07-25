package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * author : leo
 * date : 2014-5-19
 * comment : 
 * stack使用ArrayDequeue:stack性能优于Stack,queue性能优于LinkedList
 */
public class ValidParentheses {

	public static void main(String[] args) {

		String s = "(){}()[]";

		boolean result = isValid(s);

		System.out.println(result);
	}

	public static boolean isValid(String s) {

		String left = "([{";
		String right = ")]}";
		Deque<Integer> stack = new ArrayDeque<Integer>();
		char ch;
		int index;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			index = left.indexOf(ch);
			if (index != -1) {
				stack.push(index);
			} else {
				index = right.indexOf(ch);
				if (stack.isEmpty() || stack.pop() != index) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
