package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

	public static void main(String[] args) {

		String result = simplifyPath("/../");

		System.out.println(result);
	}

	public static String simplifyPath(String path) {

		path += "/";
		Deque<String> deque = new ArrayDeque<String>();
		int start, end;
		start = end = 0;

		for (int i = 1; i < path.length(); i++) {
			if (path.charAt(i) == '/') {
				start = end;
				end = i;
				String pattern = path.substring(start + 1, end);
				if (!pattern.equals("") && !pattern.equals(".")) {
					if (pattern.equals("..")) {
						if (!deque.isEmpty()) {
							deque.pollLast();
						}
					} else {
						deque.offerLast(pattern);
					}
				}
			}
		}

		StringBuilder result = new StringBuilder();
		while (!deque.isEmpty()) {
			result.append('/').append(deque.pollFirst());
		}

		return result.length() == 0 ? "/" : result.toString();
	}
}
