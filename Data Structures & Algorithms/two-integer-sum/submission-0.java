class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.containsValue(nums[i])) {
                return new int[]{getKey(seen, nums[i]), i};
            }
            seen.put(i, target - nums[i]);
        }
        return null;
    }

    public static int getKey(Map<Integer,Integer> valueMap, int value) {
        return valueMap
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue().equals(value))
            .findFirst()
            .map(Map.Entry::getKey)
            .get();
    }
}
