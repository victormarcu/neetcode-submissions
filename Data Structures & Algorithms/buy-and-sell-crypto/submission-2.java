class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buyPrice = prices[i] < buyPrice ? prices[i] : buyPrice;
            maxP = prices[i] - buyPrice > maxP ? prices[i] - buyPrice : maxP;
        }
        return maxP;
    }
}
