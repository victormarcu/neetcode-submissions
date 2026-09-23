class Solution {
    public boolean isHappy(int n) {
        Set<Integer> uniqueResults = new HashSet<>();
        while (true) {
            int sumOfSquares = getSumOfSquares(n);
            if (sumOfSquares == 1) {
                return true;
            }
            if (uniqueResults.add(sumOfSquares) == false) {
                return false;
            }
            n = sumOfSquares;
        }
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 9) {
            sum += Math.pow((n % 10), 2);
            n = n / 10;
        }
        sum += Math.pow(n, 2);
        return sum;
    }
}
