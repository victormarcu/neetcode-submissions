class Solution {
public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> frequencyS = populateFrequencyMap(s);
        Map<Character, Integer> frequencyT = populateFrequencyMap(t);

        for (char c : frequencyS.keySet()) {
            if (!frequencyT.containsKey(c)) {
                return false;
            }
            if (!frequencyS.get(c).equals(frequencyT.get(c))) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> populateFrequencyMap(String inputString) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }
}
