class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Character, Integer>, ArrayList<String>> freqDictReversed = new HashMap<>();
        for (String str : strs) {
            Map<Character,Integer> freq = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                freq.put(str.charAt(i), freq.getOrDefault(str.charAt(i), 0) + 1);
            }

            ArrayList<String> listForFreq = freqDictReversed.computeIfAbsent(freq, k -> new ArrayList<String>());
            listForFreq.add(str);
            freqDictReversed.put(freq, listForFreq);
        }
        return new ArrayList<>(freqDictReversed.values());
    }
}
