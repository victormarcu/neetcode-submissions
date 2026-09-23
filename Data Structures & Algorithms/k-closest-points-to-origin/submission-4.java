class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            
            minHeap.add(new int[]{dist, x, y});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int index = 0;
        // for (int[] i = 0; i < )
        while (!minHeap.isEmpty()) {
            int[] entry = minHeap.poll();
            res[index][0] = (int) entry[1];
            res[index][1] = (int) entry[2];
            index++;
        }
        return res;
    }
}
