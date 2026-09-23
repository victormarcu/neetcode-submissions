class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        boolean allDigitsAreNine = true;
        for (int digit : digits) {
            if (digit != 9) allDigitsAreNine = false;
        }
        if (allDigitsAreNine) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        int[] res = new int[digits.length];
        boolean hasCarry = true;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (hasCarry) {
                if (digits[i] + carry > 9) {
                    hasCarry = true;
                    digits[i] = 0;
                } else {
                    hasCarry = false;
                    digits[i]++;
                    break;
                }
            }
        }
        return digits;
    }
}
