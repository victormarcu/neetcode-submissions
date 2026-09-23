class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int res = 1;
        int l = 0;
        Set<Character> uniqueChars = new HashSet<>();
        
        // z x y z t z x y
        for (int r = 0; r < s.length(); r++) {
            while (uniqueChars.contains(s.charAt(r))) {
                uniqueChars.remove(s.charAt(l));
                l++;
            }
            uniqueChars.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
