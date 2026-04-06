import java.util.stream.IntStream;

public class FibAdv {
	private int last = 0, next = 1;

	private IntStream stream() {
		return IntStream.generate(() -> {
			int old = last;
			last = next;
			next = old + last;
			return old;
		});
	}

	public static void main(String[] args) {
		FibAdv fib = new FibAdv();
		 fib.stream()
			 .limit(9)
			 .forEach(System.out::println);
	}
}
