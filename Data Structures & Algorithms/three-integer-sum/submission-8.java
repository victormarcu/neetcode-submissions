class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // [-1,0,1,2,-1,-4]
        // [-4,-1,-1,0,1,2]
        Arrays.sort(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            int targetSum = 0 - nums[i];
            System.out.println("For " + nums[i] + " checking for two numbers summing to: " + targetSum);
            while (l < r) {
                System.out.println("Checking nums[" + l + "]=" + nums[l] + " and nums[" + r + "]=" + nums[r]);
                int twoSum = nums[l] + nums[r];
                if (twoSum == targetSum) {
                    set.add(List.of(nums[i], nums[l], nums[r]));
                    r--;
                }
                if (twoSum < targetSum) {
                    l++;
                }
                if (twoSum > targetSum) {
                    r--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
