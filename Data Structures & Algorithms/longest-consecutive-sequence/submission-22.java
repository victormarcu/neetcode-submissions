class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;

        Set<Integer> store = new HashSet<>();
        for (Integer num : nums) store.add(num);

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            if (store.contains(nums[i] - 1)) {
                continue;
            }

            int length = 1;
            int current = nums[i];
            // [2,20,10,3,4,5]
            while (store.contains(current + 1)) {
                length++;
                current = current + 1;
            }
            maxLength = length > maxLength ? length : maxLength;
        }
        return maxLength;
    }
}
