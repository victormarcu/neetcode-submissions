class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return Arrays.asList(Arrays.asList(""));
        }
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
        
        for (String string : strs) {
            Map<Character, Integer> frequencyMap = getFrequencyMap(string);
            // anagrams.computeIfAbsent(frequencyMap, v -> new ArrayList<>()).add(string);
            
            if (anagrams.containsKey(frequencyMap)) {
                anagrams.get(frequencyMap).add(string);
                continue;
            }
            anagrams.put(frequencyMap, new ArrayList<>(List.of(string)));
        }

        for (Map.Entry<Map<Character, Integer>, List<String>> entry : anagrams.entrySet()) {
            groupedAnagrams.add(entry.getValue());
        }
        return groupedAnagrams;
    }

    private static Map<Character, Integer> getFrequencyMap(String string) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : string.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
