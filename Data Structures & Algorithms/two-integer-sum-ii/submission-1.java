class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            right--;

            if (right == left) {
                left++;
                right = numbers.length - 1;
            }
        }
        return new int[]{};
    }
}
