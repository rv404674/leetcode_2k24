package string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // compute length
        int mnLength = Integer.MAX_VALUE;
        for (String s : strs) {
            mnLength = Math.min(mnLength, s.length());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mnLength; i++) {
            boolean toBeAdded = true;
            char currentChar = strs[0].charAt(i);

            for (String s : strs) {
                if (s.charAt(i) != currentChar) {
                    toBeAdded = false;
                    break;
                }
            }

            if (!toBeAdded) {
                // break if you see the first char that doesnt matches, as you want prefix.
                break;
            }

            stringBuilder.append(currentChar);
        }

        return stringBuilder.toString();
    }
}
