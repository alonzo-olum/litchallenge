import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Using brute force
class LongestSubstr {
	public static void main(String[] args) {
		String arg = args[0];
		System.out.println(longestSubstr(arg));
	}

	public static String longestSubstr(String s) {
		int n = s.length();
		int maxStart = 0, maxLength = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		for (int start = 0, end = 0; end < n; end++) {
			char c = s.charAt(end);
			// repeating char, reset start
			if (charMap.containsKey(c))
				start = Math.max(start, charMap.get(c) + 1);
			charMap.put(c, end);
      int currentLength = end - start + 1;
			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxStart = start;
			}
		}
		return s.substring(maxStart, maxStart + maxLength);
	}
}
