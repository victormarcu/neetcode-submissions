class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // [-1,0,1,2,-1,-4]
        // [-4,-1,-1,0,1,2,2,3,4]
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // first number > 0 --> all numbers positive stop
            if (nums[i] > 0) break;
            // if second number checked is equal to previous we're duplicating work
            // only check starting with second element
            if (i > 0 && nums[i] ==  nums[i-1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            int targetSum = 0 - nums[i];
            while (l < r) {
                int twoSum = nums[l] + nums[r];
                if (twoSum < targetSum) {
                    l++;
                }
                if (twoSum > targetSum) {
                    r--;
                }

                if (twoSum == targetSum) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    // increment left and right
                    // search for next unique left 
                    // (e.g. we were at 1, after increment we're still at one 
                    //  we NEED to skip because we'll get the same pair)
                    l++; r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }

            }
        }

        return result;
    }
}
