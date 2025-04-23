import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LuhnCheckSum {
	private static int doubleDigit(int digit) {
		int checkSum = 0;
		int doubleDigit = 2 * digit;
		if (doubleDigit > 10) {
			checkSum += 1 + doubleDigit % 10;
		} else {
			checkSum += doubleDigit;
		}
		return checkSum;
	}

	private static int evenLengthChecksum(int[] digits) {
		return IntStream.range(1, digits.length)
			.filter(i -> i % 2 == 0)
			.map(i -> doubleDigit(digits[i] - '0'))
			.sum();
	}

	private static int oddLengthChecksum(int[] digits) {
		return IntStream.range(0, digits.length)
			.filter(i -> i % 2 != 0)
			.map(i -> digits[i])
			.sum();
	}

	private static void calculateChecksum(int[] digits) {
		int checkSum = evenLengthChecksum(digits) + 
			oddLengthChecksum(digits);
		 System.out.println(checkSum % 10 == 0 ?  "valid" : "invalid"); 
	}

	public static void main(String[] args) {
		int[] digits = Stream.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		LuhnCheckSum.calculateChecksum(digits);
	}
}
