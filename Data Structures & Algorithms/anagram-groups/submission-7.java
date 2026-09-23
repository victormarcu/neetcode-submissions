class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> dictAnagrams = new HashMap<>();

        for(String str : strs) {
            dictAnagrams.computeIfAbsent(getFreqMap(str), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList(dictAnagrams.values());
    }

    private String getFreqMap(String string) {
        int[] freqMap = new int[26];
        for (Character c : string.toCharArray()) {
            freqMap[c - 'a']++;
        }
        return Arrays.toString(freqMap);
    }
}
