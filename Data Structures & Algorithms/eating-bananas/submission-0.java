class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxP = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > maxP)  maxP = pile;
        }
        if (piles.length == h) return maxP;

        int l = 1;
        int r = maxP;
        int minK = Integer.MAX_VALUE;
        while (l <= r) {
            int k = (l + r) / 2;
            int hoursTaken = 0;
            for (int i = 0; i < piles.length; i++) {
                // hoursTaken += (int) Math.ceil((double) piles[i] / piles[k]);
                hoursTaken += (int) Math.ceil((double) piles[i] / k);
            }
            if (hoursTaken > h) {
                l = k + 1;
            } else {
                minK = Math.min(minK, k);
                r = k - 1;
            }
        }
        return minK;
    }
}
