import java.util.stream.IntStream;

class NumberStartingOne {

	public static void startingWithOne(int[] numbers) {
		IntStream
			.of(numbers)
			.filter(NumberStartingOne::startsWithOne)
			.forEach(System.out::println);
	}

	private static boolean startsWithOne(int number) {
		return String.valueOf(number).startsWith("1");
	}


	public static void main(String[] args) {
		int[] numbers = new int[] {12, 34, 365, 56, 23, 112, 102};
		NumberStartingOne.startingWithOne(numbers);
	}
}
