class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diffToTarget = target - nums[i];
            if (diffMap.containsKey(diffToTarget)) {
                return new int[]{diffMap.get(diffToTarget), i};
            }
            diffMap.put(nums[i], i);
        }
        return new int[]{0,1};
    }
}
