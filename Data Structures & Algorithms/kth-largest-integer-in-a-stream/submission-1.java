class KthLargest {
    int max = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);

    public KthLargest(int k, int[] nums) {
        max = k;
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > max) heap.poll();
        return heap.peek();
    }
}
