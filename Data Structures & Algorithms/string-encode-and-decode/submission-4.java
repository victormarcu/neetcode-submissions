class Solution {

    private static final String DELIMITER ="#";

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String string : strs) {
            builder.append(string.length()).append(DELIMITER);
            for (char c : string.toCharArray()) {
                builder.append(c);
            }
        }
        System.out.println(builder);
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> resultList = new ArrayList<>();
        StringBuilder toDecode = new StringBuilder(str);

        while (toDecode.length() > 0) {
            int i = 0;
            StringBuilder lengthSb = new StringBuilder();
            while (i < toDecode.length() && toDecode.charAt(i) != '#') {
                lengthSb.append(toDecode.charAt(i));
                i++;
            }
            int wordLength = Integer.parseInt(lengthSb.toString());
            toDecode.delete(0, i + 1);
            System.out.println(toDecode.toString());
            resultList.add(toDecode.substring(0, wordLength));
            toDecode.delete(0, wordLength);
        }   
        return resultList;
    }
}
