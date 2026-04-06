
public class FibMemo {
	private static int fib(int n) {
		int[] memo = new int[n+1];
		if (n < 2) return 1; 
		if (memo[n] > 0) {
			return memo[n];
		}
			memo[n] = fib(n-1) + fib(n-2);
			return memo[n];
	}

	public static void main(String[] args) {
		System.out.println(FibMemo.fib(5));
	}
}
