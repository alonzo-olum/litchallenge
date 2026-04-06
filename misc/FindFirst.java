import java.util.Arrays;
import java.util.stream.Stream;

class FindFirst {
	public static void find(int[] numbers) {
		Arrays
			.stream(numbers)
			.findFirst()
			.ifPresent(System.out::println);
	}

	public static void main(String[] args) {
		int[] numbers = Stream
			.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		FindFirst.find(numbers);
	}
}
