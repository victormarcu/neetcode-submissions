class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int maxStone = maxHeap.poll();
            int secondStone = maxHeap.poll();
            if (maxStone == secondStone) {
                continue;
            } else if (secondStone < maxStone) {
                maxHeap.offer(maxStone - secondStone);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
