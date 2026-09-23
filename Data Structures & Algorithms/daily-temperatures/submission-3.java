class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> stack = new ArrayDeque<>();
        // add indexes(or temps) for which we dont know max temp to the stack
        // 
        // on next element, if its greater than the top of the stack so far
        // 
        // stack size represents elements back
        // [30, 38, 30, 36, 35, 40, 28]
        // [ 1,  4,  1,  2,  1,  0,  0]
        int[] res = new int[temp.length];
        stack.push(0);
        for (int i = 1; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}
