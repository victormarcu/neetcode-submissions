class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.isEmpty()) return true;
        if (s2 == null || s2.isEmpty()) return false;
        if (s1.length() > s2.length())  return false;
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freqS1, freqS2)) {
            return true;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            freqS2[s2.charAt(r) - 'a']++;
            freqS2[s2.charAt(l) - 'a']--;
            if (Arrays.equals(freqS1, freqS2)) {
                return true;
            }
            l++;
        }
        return false;
    }
}
