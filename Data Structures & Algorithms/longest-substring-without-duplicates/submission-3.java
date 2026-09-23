class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        // z x y z t x y
        int l = 0;
        int maxLength = 1;

        Set<Character> store = new HashSet<>();
        for (int r = 0; r < s.length(); r++) {
                while (l < r && store.contains(s.charAt(r))) {
                    store.remove(s.charAt(l));
                    l++;
                }

            store.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - l  + 1);
        }
        return maxLength;
    }
}
