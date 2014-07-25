package string;

public class CountandSay {

	public static void main(String[] args) {

		String result = countAndSay(4);

		System.out.println(result);
	}

	public static String countAndSay(int n) {

		StringBuilder result = new StringBuilder("1");

		for (int i = 2; i <= n; i++) {
			char ch = result.charAt(0);
			int count = 1;
			StringBuilder sb = new StringBuilder();

			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) == ch) {
					count++;
				} else {
					sb.append(count).append(ch);
					ch = result.charAt(j);
					count = 1;
				}
			}

			sb.append(count).append(ch);
			result = sb;
		}

		return result.toString();
	}
}
