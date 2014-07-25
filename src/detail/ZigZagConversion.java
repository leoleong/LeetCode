package detail;

public class ZigZagConversion {

	public static void main(String[] args) {

		String result = convert("PAYPALISHIRING", 3);

		System.out.println(result);
	}

	public static String convert(String s, int nRows) {

		// in case TLE
		if (s.length() < 2 || nRows < 2) {
			return s;
		}
		
		StringBuilder result = new StringBuilder(s.length());
		for (int i = 0; i < nRows; i++) {
			int index = i;
			for (; index < s.length(); index += (nRows - 1) * 2) {
				result.append(s.charAt(index));
				if (i == 0 || i == nRows - 1)
					continue;
				if (index + (nRows - 1 - i) * 2 < s.length())
					result.append(s.charAt(index + (nRows - 1 - i) * 2));
			}
		}

		return result.toString();
	}
}
