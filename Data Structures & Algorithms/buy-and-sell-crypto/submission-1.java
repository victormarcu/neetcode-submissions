class Solution {
    public int maxProfit(int[] prices) {
        int bestPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bestPrice) {
                bestPrice = prices[i];
                continue;
            }
            maxProfit = prices[i] - bestPrice > maxProfit ? prices[i] - bestPrice : maxProfit;
        }
        return maxProfit;
    }
}
