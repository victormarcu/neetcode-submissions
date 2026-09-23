class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }
        // ab abcd
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            s2Count[s2.charAt(r) - 'a']++;
            s2Count[s2.charAt(l) - 'a']--;
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            l++;
        }
        return false;
    }
}
