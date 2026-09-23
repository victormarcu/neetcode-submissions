class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append('\0').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty()) return Collections.emptyList();
        List<String> res = new ArrayList<>();
        
        // 2#ab
        int left = 0;
        while (left < str.length()) {
            int delimiter = str.indexOf('\0', left);
            int length = Integer.parseInt(str.substring(left, delimiter));
            int start = delimiter + 1;
            res.add(str.substring(start, start + length));
            left = start + length;
        }
        return res;
    }
}
