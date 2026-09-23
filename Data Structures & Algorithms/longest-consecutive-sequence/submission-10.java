class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int length = 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > current && current + 1 == nums[j]) {
                    length++;
                    current = nums[j];
                    j = -1;
                }
                maxLength = length > maxLength ? length : maxLength; 
            }
        }
        return maxLength;
    }
}
