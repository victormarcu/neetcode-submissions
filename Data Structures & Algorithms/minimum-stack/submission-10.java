class MinStack {
    private List<Integer> stack;
    private int min = Integer.MAX_VALUE;
    private Map<Integer, Integer> minMap;
    
    public MinStack() {
        stack = new ArrayList<>();
        minMap = new HashMap<>();
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        stack.add(val);
        minMap.put(stack.size() - 1, min);
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
        if (stack.size() > 0) {
            min = minMap.get(stack.size() - 1);
        } else {
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return min;
    }
}
