class Solution {
    public boolean isPalindrome(String s) {
        if (s.trim().isEmpty()) return true;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        if (sb.isEmpty()) return true;
        int start = 0;
        int end = sb.length() - 1;
        while (sb.charAt(start) == sb.charAt(end)) {
            if (start == sb.length() / 2) return true;
            start++;
            end--;
        }
        return false;
    }
}
