package string;

public class LengthofLastWord {

	public static void main(String[] args) {

		int result = lengthOfLastWord("hello world ");

		System.out.println(result);
	}

	public static int lengthOfLastWord(String s) {

		int len = 0;
		int end = s.length() - 1;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				end = i;
				break;
			}
		}
		for (int i = end; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				break;
			}
			len++;
		}

		return len;
	}
}
