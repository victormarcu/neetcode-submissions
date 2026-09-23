class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            System.out.println("comparing coordinates " + x + " and " + y + " distance: " + dist);
            
            minHeap.add(new double[]{dist, x, y});
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
            double[] entry = minHeap.poll();
            res[index][0] = (int) entry[1];
            res[index][1] = (int) entry[2];
            index++;
        }
        return res;
    }
}
