/**
 * Problem:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 * 	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
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

		Deque<Integer> stack = new ArrayDeque<Integer>();
		int oprand;

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
