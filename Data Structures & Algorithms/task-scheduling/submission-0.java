class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t : tasks) {
            count[t - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;

        // holds a mapping between remaining_count AND time + n
        Queue<int[]> q = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if(maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
