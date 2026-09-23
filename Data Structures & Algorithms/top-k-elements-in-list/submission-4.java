class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int number : nums) {
            freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
        }

        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(new Integer[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = minHeap.poll()[1];
        }
        return result;
    }
}
