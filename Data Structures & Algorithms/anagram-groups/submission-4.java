class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Character, Integer>, ArrayList<String>> freqDict = new HashMap<>();
        for (String str : strs) {
            Map<Character,Integer> freq = getFrequency(str);
            freqDict.computeIfAbsent(freq, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(freqDict.values());
    }

    private Map<Character,Integer> getFrequency(String string) {
        Map<Character,Integer> freq = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            freq.put(string.charAt(i), freq.getOrDefault(string.charAt(i), 0) + 1);
        }
        return freq;
    }
}
