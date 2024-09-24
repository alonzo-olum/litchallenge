import java.util.stream.IntStream;
import java.util.stream.Stream;

class CubeNumbers {

	// cube of numbers greater than value 50
	public static void cubeNumbers(int[] numbers) {
		IntStream
			.of(numbers)
			.mapToDouble(CubeNumbers::cube)
			.filter(CubeNumbers::isGreaterThan50)
			.forEach(System.out::println);
	}

	// numbers whose cube are greater than 50
	// without mutation
	public static void peekCubeNumbers() {
		IntStream
			.range(1, 10)
			.filter(CubeNumbers::cubeGreaterThan50)
			.forEach(System.out::println);
	}

	private static boolean isGreaterThan50(double number) {
		// wish, we could get some kind of in-built
		// comparison function
		return Double.compare(number, 50) > 0;
	}

	private static double cube(int number) {
		return Math.pow(number, 3);
	}

	// non-mutative boolean
	// check if copy of cube of number `isGreaterThan50`
	private static boolean cubeGreaterThan50(int number) {
		return CubeNumbers.isGreaterThan50(CubeNumbers.cube(number));
	}

	public static void main(String[] args) {
		int[] nums = Stream
			.of(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		CubeNumbers.cubeNumbers(nums);
	}
}
