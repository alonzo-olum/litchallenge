import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class DuplicateElements {
	public static void find(int[] numbers) {
		Set<Integer> collect = new HashSet<>();
		IntStream
			.of(numbers)
			.filter(n -> !collect.add(n))
			.forEach(System.out::println);
	}

	public static void main(String[] args) {
		int[] numbers = Stream.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		DuplicateElements.find(numbers);
	}
}
