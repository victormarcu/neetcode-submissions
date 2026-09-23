class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> frequency = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequency.add(nums[i]))
                return true;
        }
        return false;
    }
}
