class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // int[] map = new int[41];
            // int product = 1;
            // for (int j = 0; j < nums.length && j != i; j++) {

            // }
            result.add(prodExceptSelf(i, nums));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private Integer prodExceptSelf(int index, int[] nums) {
        int productBeforeIndex = 1;
        int productAfterIndex = 1;
        for (int i = 0; i < index; i++) {
            productBeforeIndex *= nums[i];
        }
        // [0, 3, 5, 8]
        for (int i = index + 1; i < nums.length; i++) {
            productAfterIndex *= nums[i];
        }
        return productBeforeIndex * productAfterIndex;
    }
}  
