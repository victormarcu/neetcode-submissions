class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
            if (string == null) throw new IllegalArgumentException("Null strings are not supported");
            sb.append(string.length()).append('\0').append(string);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty()) return Collections.emptyList();
        List<String> res = new ArrayList<>();

        int left = 0;
        while (left < str.length()) {
            int delimiterIndex = str.indexOf('\0', left);
            if (delimiterIndex == -1) throw new IllegalArgumentException("Malformed encoded string");
            int length = Integer.parseInt(str.substring(left, delimiterIndex));
            
            int start = delimiterIndex + 1;
            res.add(str.substring(start, start + length));
            left = start + length;
        }
        return res;
    }
}
