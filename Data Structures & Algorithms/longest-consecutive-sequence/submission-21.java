class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) store.add(num);

        int maxLength = 1;
        for (int i = 0; i< nums.length; i++) {
            if (store.contains(nums[i] - 1)) {
                continue;
            }
            
            int length = 1;
            int current = nums[i];
            while (store.contains(current + 1)) {
                length++;
                current = current + 1;
            }

            maxLength = length > maxLength ? length : maxLength;
        }


        return maxLength;
    }
}
