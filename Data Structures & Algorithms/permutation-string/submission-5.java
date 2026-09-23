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

        Map<Character, Integer> freqMapS1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqMapS1.put(c, freqMapS1.getOrDefault(c, 0) + 1);
        }
        
        
        for (int i = 0; i < s2.length(); i++) {
            if (s1.indexOf(s2.charAt(i)) != -1) {
                Map<Character, Integer> freqMapS2 = new HashMap<>();
                int r = i;
                while (r < s2.length() && s1.indexOf(s2.charAt(r)) != -1 && r - i < s1.length()) {
                    freqMapS2.put(s2.charAt(r), freqMapS2.getOrDefault(s2.charAt(r), 0) + 1);
                    r++;
                }
                if (freqMapS1.equals(freqMapS2)) {
                    return true;
                }
            } 
        }
        return false;
    }
}
