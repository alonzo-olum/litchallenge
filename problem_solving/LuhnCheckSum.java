import java.util.stream.Stream;
import java.util.stream.IntStream;

import java.util.function.Function;
import java.util.function.Predicate;

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

	// oddLengthChecksum calculates the checksum of odd digits
	private static int oddLengthChecksum(int[] digits) {
		Predicate<Integer> filterFn = i -> i % 2 == 0;
		Function<Integer, Integer> mapperFn = i -> add(2 * digits[i-1]);
		int evenPositions =
			LuhnCheckSum
			.filterAndMap(IntStream.range(1, digits.length),
					filterFn, mapperFn);

		filterFn = i -> i % 2 != 0;
		mapperFn = i -> add(digits[i-1]);
		// +1 in odd positions indicates the last digit is inclusive
		int oddPositions =
			LuhnCheckSum
			.filterAndMap(IntStream.range(1, digits.length+1),
					filterFn, mapperFn);

		return oddPositions + evenPositions;
	}

		// evenLengthChecksum calculates the checksum of even digits
	private static int evenLengthChecksum(int[] digits) {
		Predicate<Integer> filterFn = i -> i % 2 != 0;
		Function<Integer, Integer> mapperFn = i -> add(2 * digits[i-1]);
		// for odd positions we know we can omit the last digit
		int oddPositions =
			LuhnCheckSum
			.filterAndMap(IntStream.range(1, digits.length),
					filterFn, mapperFn);

		filterFn = i -> i % 2 == 0;
		mapperFn = i -> add(digits[i-1]);
		// +1 in even positions indicates the last digit is inclusive
		int evenPositions =
			LuhnCheckSum
			.filterAndMap(IntStream.range(1, digits.length+1),
					filterFn, mapperFn);

		return oddPositions + evenPositions;
	}

	private static int add(int num) {
		int checkSum = 0;
		while (num != 0) {
			int pop = num % 10;
			num /= 10;
			checkSum += pop;
		}
		return checkSum;
	}

	private static int filterAndMap(IntStream istream, Predicate<Integer> filter, Function<Integer, Integer> mapper) {
		IntStream filteredStream = LuhnCheckSum.filter(istream, filter);
		return LuhnCheckSum.map(filteredStream, mapper)
			.sum();
	}

	private static IntStream filter(IntStream istream, Predicate<Integer> predicate) {
		return istream.filter(predicate::test);
	}

	private static IntStream map(IntStream istream, Function<Integer, Integer> mapper) {
		return istream.map(mapper::apply);
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
