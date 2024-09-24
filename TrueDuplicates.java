import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import java.util.stream.Collectors;

class TrueDuplicates {
	public static boolean ifDuplicate(int[] numbers) {
		List<Integer> numList = Arrays
			.stream(numbers)
			.boxed()
			.collect(Collectors.toList());

		Set<Integer> numSet = new HashSet<>(numList);
		return numList.size() == numSet.size() ? false : true;
	}

	// Helper parse arguments on command line
	public static int[] parseArgsToInt(String[] args) {
		return Stream
			.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
	}

	public static void main(String[] args) {
		int[] numbers = TrueDuplicates.parseArgsToInt(args);
		System.out.println(TrueDuplicates.ifDuplicate(numbers));
	}
}
