class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (uniqueSet.contains(nums[i])) {
                return true;
            } 
            uniqueSet.add(nums[i]);
        }
        return false; 
    }
}