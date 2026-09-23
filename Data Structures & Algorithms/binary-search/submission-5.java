class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // [ -1, 0, 2, 4, 5, 6, 8] - 6
        while (l <= r) {
            int half = (l + r) / 2;
            if (nums[half] == target) return half;
            if (target < nums[half])  r = half - 1;
            else l = half +1; 
        }
        return -1;
    }
}
