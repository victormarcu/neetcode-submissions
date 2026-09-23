class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
            sb.append(string.length());
            sb.append("@");
            sb.append(string);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return Collections.emptyList();
        
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimiterPos = str.indexOf("@", i);

            int length = Integer.parseInt(str.substring(i, delimiterPos));
            int start = delimiterPos + 1;

            String string = str.substring(start, start + length);
            result.add(string);
            
            i = start + length;
        }
        return result;
    }
}
