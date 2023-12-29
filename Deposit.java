
class Deposit {
	private static final double GOLDEN_RATIO = (1 + Math.sqrt(5))/2;
	private static int NTH_DEPOSIT = 20;
	private static double FINAL_AMT = 10000000;

	public static double solve() {
		while (NTH_DEPOSIT > 0) {
			FINAL_AMT /= GOLDEN_RATIO;
			NTH_DEPOSIT--;
		}
		return FINAL_AMT;
	}

	public static void main(String[] args) {
		System.out.println(Deposit.solve());
	}
}
