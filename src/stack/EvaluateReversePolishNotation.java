package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

		String[] tokens = new String[] { "4", "3", "-" };

		int result = evalRPN(tokens);

		System.out.println(result);
	}

	public static int evalRPN(String[] tokens) {

		int oprand;
		Deque<Integer> stack = new ArrayDeque<Integer>();

		for (String token : tokens) {
			if (token.equals("+")) {
				oprand = stack.pop();
				oprand += stack.pop();
			} else if (token.endsWith("-")) {
				oprand = stack.pop();
				oprand = stack.pop() - oprand;
			} else if (token.endsWith("*")) {
				oprand = stack.pop();
				oprand *= stack.pop();
			} else if (token.endsWith("/")) {
				oprand = stack.pop();
				oprand = stack.pop() / oprand;
			} else {
				oprand = Integer.parseInt(token);
			}
			stack.push(oprand);
		}

		return stack.pop();
	}
}
