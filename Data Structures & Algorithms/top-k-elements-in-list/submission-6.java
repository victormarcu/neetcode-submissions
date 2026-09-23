class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(new Integer[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll()[1];
        }
        return res;
    }
}
