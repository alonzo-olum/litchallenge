import java.util.stream.IntStream;
import java.util.stream.Stream;

class EvenNumber {
	
	public static void even(int [] numbers) {
		IntStream.of(numbers)
			.filter(EvenNumber::isEven)
			.forEach(System.out::println);
	}

	// here a modulo function could be great!
	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static void main(String[] args) {
		int[] numbers = Stream
			.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		EvenNumber.even(numbers);
	}
}
