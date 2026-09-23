class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = prices.length - 1;
        int maxProfit = 0;
        while (l < r) {
            int profit = -prices[l] + prices[r];
            maxProfit = profit > maxProfit ? profit : maxProfit;
            r--;
            if (l == r) {
                l++;
                r = prices.length-1;
            }
        }
        return maxProfit;
    }
}
