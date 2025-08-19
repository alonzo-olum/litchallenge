import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * LuhnCheckSum a widely used system for validation of
 * identification number. Using the original number we
 * double every other digit from the rightmost end.
 * Example: 1 7 6 2 4 8 3
 * we double 8, 2, 7 adding each individual digit
 * otherwise we add the other digits in other positions.
 * we then check if the total sum is divisible by 10.
 */
public class LuhnCheckSum {
	private static int add(int num) {
		int checkSum = 0;
		while (num != 0) {
			int pop = num % 10;
			num /= 10;
			checkSum += pop;
		}
		System.out.println("add: " + checkSum);
		return checkSum;
	}

	// oddLengthChecksum calculates the checksum of odd digits
	private static int oddLengthChecksum(int[] digits) {
		// for even positions we know we can omit the last digit
		int evenPositions = IntStream.range(1, digits.length)
			.filter(i -> i % 2 == 0)
			.map(i -> add(2 * digits[i-1]))
			.sum();
		System.out.println("evenPositions for odd-length checksum: " + evenPositions);
		// +1 in odd positions indicates the last digit is inclusive
		int oddPositions = IntStream.range(1, digits.length+1)
			.filter(i -> i % 2 != 0)
			.map(i -> add(digits[i-1]))
			.sum();
		System.out.println("oddPositions for odd-length checksum: " + oddPositions);
		return oddPositions + evenPositions;
	}

	// evenLengthChecksum calculates the checksum of even digits
	private static int evenLengthChecksum(int[] digits) {
		// for odd positions we know we can omit the last digit
		int oddPositions = IntStream.range(1, digits.length)
			.filter(i -> i % 2 != 0)
			.map(i -> add(2 * digits[i-1]))
			.sum();
		System.out.println("oddPositions for even-length checksum: " + oddPositions);
		// +1 in even positions indicates the last digit is inclusive
		int evenPositions = IntStream.range(1, digits.length+1)
			.filter(i -> i % 2 == 0)
			.map(i -> add(digits[i-1]))
			.sum();
		System.out.println("evenPositions for even-length checksum: " + evenPositions);
		return oddPositions + evenPositions;
	}

	private static void calculateChecksum(int[] digits) {
		int checkSum = 0;
		if (digits.length % 2 == 0) {
			// even length checksum
			checkSum = evenLengthChecksum(digits);
		} else {
			checkSum = oddLengthChecksum(digits);
		}
		System.out.println(checkSum % 10 == 0 ?  "valid" : "invalid");
	}

	public static void main(String[] args) {
		int[] digits = Stream.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		LuhnCheckSum.calculateChecksum(digits);
	}
}
