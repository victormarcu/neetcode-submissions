class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // 1,1,1,5,5,7,7,7,3,3,3
        // 1 - 3
        // 3 - 3
        // 5 - 2
        // 7 - 3
        // 0,0,0,0,0,0,0,0,0,0,0,0
        // 0,0,2,3,0,0,0,0,0,0,0,0
        // | | | | | | | | | | | |
        // 0,0[5][1]0,0,0,0,0,0,0,0
        // 0,0,0,[3]0,0,0,0,0,0,0,0
        // 0,0,0,[7]0,0,0,0,0,0,0,0
        List<Integer>[] buckets = new List[nums.length +1];
        for (Map.Entry<Integer,Integer> entry : freqMap.entrySet()) {
            int number = entry.getKey();
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(number);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        int[] answ = new int[k];
        for (int i = 0; i < k; i++) {
            answ[i] = result.get(i);
        }
        return answ;
    }
}
