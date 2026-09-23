class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // create freqMap of s1
        // iterate through s2
            // if (currentChar contained in s1) 
                // create new freqMap for this sliding window
                // int r = i;
                // while (s2.indexAt(r) appears in s1 && r - i <= s1.length && i + r < s2.length)
                    // add element to new freqMap.
                // if freqMap2.equals(freqMap) 
                    // return true;

        int[] s1Map = new int[26];
        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (s1.indexOf(s2.charAt(i)) != -1) {
                int[] s2Map = new int[26];
                int r = i;
                while (r < s2.length() && s1.indexOf(s2.charAt(r)) != -1 && r - i < s1.length()) {
                    s2Map[s2.charAt(r) - 'a']++;
                    r++;
                }
                if (Arrays.toString(s1Map).equals(Arrays.toString(s2Map))) {
                    return true;
                }
            } 
        }
        return false;
    }
}
