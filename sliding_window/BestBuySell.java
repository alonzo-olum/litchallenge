
public class BestBuySell {

	private int[] prices;

	public BestBuySell(int[] prices) {
		this.prices = prices;
	}

	public int maxProfit() {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0; i<prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i]-minPrice 
					> maxProfit) {
				maxProfit = prices[i]-minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = {7,3,2,4,6,9,14};
		BestBuySell bbS = new BestBuySell(prices);
		System.out.printf("max profits: %d", bbS.maxProfit());
	}
}
