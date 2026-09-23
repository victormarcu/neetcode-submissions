class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 1) return 1;

        int[] taskFreq = new int[26]; 
        for (char t : tasks) {
            taskFreq[t - 'A']++;
        }

        Arrays.sort(taskFreq);
        int maxf = taskFreq[25];
        int idle = (maxf - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxf - 1, taskFreq[i]);
        }
        return Math.max(0, idle) + tasks.length;
        
        // logic to be added here
        // if sleep cyle > highest count maybe we can get away with something greedy
        // logic would be to just add elemnts in terms of highest frequency ...

        // another idea would be to sort decreasing based on frequency
        // and then idk

        // tasks = [A,A,A,B,B,C], n = 2
        // A _ _ A _ _ A
        // A B C A B _ A
        // A,A,A,B,B,B,B,C,C 
        // B _ _ B _ _ B _ _ B
        // B A C B A C B A _ B
        // 2 * (3-1) = 4
        // 2 * (4-1) = 6
        // [X,X,Y,Y], n=2
        // X Y _ X Y
        // maxFreq + n * (maxFreq - 1) + ()
    }
}
