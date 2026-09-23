class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        Deque<Character> open = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                open.push(c);
                continue;
            } 
            if (open.isEmpty()) return false;
            if (brackets.get(c) != open.pop()) {
                return false;
            }
        }
        return open.isEmpty() ? true : false;
    }
}
