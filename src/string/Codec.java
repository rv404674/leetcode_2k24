package string;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    // Do it the simple way
    // Encode lenString:
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append(":").append(str);
        }

        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList();
        int i = 0;
        while (i < s.length()) {
            int index = s.indexOf(':', i);
            int len = Integer.parseInt(s.substring(i, index));

            int start = index + 1;
            int end = start + len;

            ans.add(s.substring(start, end));
            i = end;
        }

        return ans;
    }
}
