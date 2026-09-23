class Solution {
    public int[] productExceptSelf(int[] nums) {
        // if exactly 1 zero -> all numbers are zeros except zero which = prodExceptSelf
        // if more than 1 zero -> all numbers 0;
        int n = nums.length;
        int zeroCount = 0;
        int product = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            } 
            product *= nums[i];
        }

        int[] result = new int[n];
        if (zeroCount > 1) {
            return new int[n];
        }
        System.out.println("product: "+product);
        for (int i = 0; i < n; i++) {
            if (zeroCount == 1) {
                result[i] = nums[i] != 0 ? 0 : product; 
            } else {
                result[i] = product / nums[i];
            }
        }
        return result;
    }
}  
