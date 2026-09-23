class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length < 2) return false;
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) if (unique.add(num) == false)  return true;
        return false;
    }
}