import java.util.Set;
import java.util.HashSet;

// Using brute force
class LongestSubstr {
	public static int longestSubstr(String input) {
		int n = input.length();
		int out = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (LongestSubstr.allUnique(input, i, j)) {
					out = Math.max(out, j-i);
				}
			}
		}
		return out;
	}

	private static boolean allUnique(String s, int start, int end) {
		Set<Character> charset = new HashSet<>();

		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (charset.contains(ch)) return false;
			charset.add(ch);
		}
		return true;
			}
}
