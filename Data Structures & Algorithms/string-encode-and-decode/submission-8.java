class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String string : strs) {
            sb.append(string.length()).append("@").append(string);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            int delimiterPos = str.indexOf("@", i);

            int stringLength = Integer.parseInt(str.substring(i, delimiterPos));
            String string = str.substring(delimiterPos + 1, delimiterPos + stringLength + 1);
            i = delimiterPos + 1 + stringLength;

            result.add(string);
        }
        return result;
    }
}
