class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Deque<Integer> num = new ArrayDeque<>();
        int res = 0;
        for (String token : tokens) {
            if (!operators.contains(token)) {
                int number = 0;
                try {
                    number = Integer.parseInt(token);
                } catch (NumberFormatException e) {
                    System.err.println("Tried to parse non-number!");
                    continue;
                }
                num.push(Integer.parseInt(token));
                continue;
            }
            if (num.size() > 1) {
                int secondNumber = num.pop();
                num.push(calculate(num.pop(), secondNumber, token));
            } 
        }
        return num.isEmpty() ? 0 : num.pop();
    }

    private int calculate(int a, int b, String operation) {
        switch(operation) {
            case "+": 
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}
