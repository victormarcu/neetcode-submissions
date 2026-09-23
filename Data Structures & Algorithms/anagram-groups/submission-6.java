class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map<freqMap, List<Strings>>
        // freqMap = Map<Characters, Integers>
        Map<Map<Character,Integer>, ArrayList<String>> dictAnagrams = new HashMap<>();

        for(String str : strs) {
            Map<Character, Integer> freqMap = getFreqMap(str);
            dictAnagrams.computeIfAbsent(freqMap, k -> new ArrayList<>()).add(str);
            // dictAnagrams.put(freqMap, dictAnagrams.computeIfAbsent(freqMap, key -> new ArrayList<>()).add(str));
        }
        return new ArrayList(dictAnagrams.values());
    }

    private Map<Character, Integer> getFreqMap(String string) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character c : string.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }
}
