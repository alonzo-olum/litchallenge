
import java.lang.util;

class Palindrome {
	
	// Using the simple approach
	public static boolean isPalindrome
		(
		 String strings
		 ) {
			int forward = 0;
			int backward = strings.length()-1;
			while (forward < backward) {
				if (strings.charAt(forward++)
						!= strings.charAt(backward--)) {
					return false;
						}
			}
				return true;
		}
	
	// Using stringbuilder/stringbuffer API
	private static boolean isPalindromeWithApi
		(
		 String strings
		 ) {
		 StringBuilder builder = new StringBuilder(strings);
		 builder = builder.reverse();
		 return builder.toString().equals(strings);
		 }

	// Using manual reversal
	private static boolean isPalindromeReverse
		(
		 String strings
		 ) {
			StringBuilder builder = new StringBuilder();
			Char[] chars = strings.toCharArray();
			for (int i = chars.length-1; i>0; i--) {
				builder.append(chars[i]);
			}
			return builder.toString().equals(strings);
		 }

	// Using Stream API
	private static boolean isPalindromeWithStreamApi
		(
		 String strings
		 ) {
			return IntStream.range(0, strings.length()/2)
				.noneMatch(i -> strings.charAt(i) != strings.charAt(strings.length()-i-1));
		}
}
