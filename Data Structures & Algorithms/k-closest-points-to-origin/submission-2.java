class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            System.out.println("comparing coordinates " + x + " and " + y + " distance: " + dist);
            
            minHeap.add(new int[]{dist, x, y});
            System.out.println("Heap top pre-removal is: " + minHeap.peek()[0]);
            
            if (minHeap.size() > k) {
                minHeap.poll();
                System.out.println("Heap top after removal is: " + minHeap.peek()[0]);
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
