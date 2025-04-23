import java.util.HashMap;
import java.util.Map;

public class FibMemo2 {
		static Map<Integer, Integer> memo = new HashMap<>();

	private static void init() {
		memo.put(0, 0);
		memo.put(1, 1);
	}

	private static int fib(int n) {
		if (!memo.containsKey(n)) {
			memo.put(n, fib(n-1) + fib(n-2));
		}
		return memo.get(n);
	}

	public static void main(String[] args) {
		FibMemo2.init();
		System.out.println(FibMemo2.fib(10));
	}
}
