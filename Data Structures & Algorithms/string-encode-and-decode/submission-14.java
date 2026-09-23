class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
            sb.append(string.length()).append('?').append(string);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.isEmpty()) return Collections.emptyList();
        List<String> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        while (right < str.length()) {
            // gives us 1
            int delimiterIndex = str.indexOf('?', left);
            // gives us length
            int length = Integer.parseInt(str.substring(left, delimiterIndex));
            int start = delimiterIndex + 1;
            // add the string
            res.add(str.substring(start, start + length));
            left = start + length;
            right = start + length;
        }
        return res;
    }
}
