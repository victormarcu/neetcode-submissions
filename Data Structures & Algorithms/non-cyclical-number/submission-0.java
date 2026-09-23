class Solution {
    public boolean isHappy(int n) {
        // calculate sum of squares of digits
            // check if sum is 1 then return true
        // try to add result in the set of numbers we've already seen
            // if already exists return false 
        Set<Integer> uniqueResults = new HashSet<>();
        while (true) {
            int sumOfSquares = getSumOfSquares(n);
            System.out.println("sum of square digits: " + sumOfSquares);
            if (sumOfSquares == 1) {
                return true;
            }
            if (uniqueResults.add(sumOfSquares) == false) {
                System.out.println("Cycle detected, " + sumOfSquares + " already been seen");
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
