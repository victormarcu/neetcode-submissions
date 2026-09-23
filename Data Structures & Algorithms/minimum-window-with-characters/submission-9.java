class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for (int i = 0; i < t.length(); i++) {
            freqS[s.charAt(i)]++;
            freqT[t.charAt(i)]++;
        }

        if (Arrays.equals(freqS, freqT)) {
            return s.substring(0, t.length());
        }

        int minL = 1001;
        int bestL = 0;
        int bestR = 0;
        int l = 0;
        for (int r = t.length(); r < s.length(); r++) {
            freqS[s.charAt(r)]++;
            while (l < s.length() && freqS[s.charAt(l)] > freqT[s.charAt(l)]) {
                freqS[s.charAt(l)]--;
                l++;
            }

            boolean found = true;
            for (int i = 0; i < freqT.length; i++) {
                if (freqT[i] != 0 && freqS[i] < freqT[i]) {
                    found = false;
                    break;
                }
            }
            if (found && minL > r - l + 1) {
                minL = r - l + 1;
                bestL = l;
                bestR = r + 1;

            }
        }
        return bestR != 0 ? s.substring(bestL, bestR) : "";
    }
}
