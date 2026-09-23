class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return new String();
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("|");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) return Collections.emptyList();
        List<String> result = new ArrayList<String>();
        
        // 3|abc
        StringBuilder toDecode = new StringBuilder(str);
        for (int i = 0; i < toDecode.length(); i++) {
            if (toDecode.charAt(i) != '|') {
                continue;
            }

            int len = Integer.parseInt(toDecode.substring(0, i));
            int start = i + 1;

            result.add(toDecode.substring(start, start + len));
            toDecode.delete(0, start + len);
            i = -1;
        }

        return result;
    }
}
