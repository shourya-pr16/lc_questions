package arrays;

public class Stocks1 {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for(int i = 1 ; i < prices.length; i++) {
            int cost = prices[i] - minPrice;

            profit = Math.max(cost, profit);

            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
