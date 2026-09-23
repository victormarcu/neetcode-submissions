class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freqArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i) - 'a']++;
            freqArr[t.charAt(i) - 'a']--;
        }
        for (int c : freqArr) {
            if (c != 0) return false;
        }
        return true;
    }
}
