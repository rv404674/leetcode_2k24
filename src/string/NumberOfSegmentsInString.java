package string;

class Solution {
    public int countSegments(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int segments = 0;
        int curSequenceLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals(' ')) {
                // if you encounter a space, check if last str was a segment, if yes increment.
                if (curSequenceLen != 0) {
                    segments++;
                }

            } else {
                curSequenceLen++;
            }
        }

        if (curSequenceLen != 0) {
            segments++;
        }

        return segments;
    }
}

public class NumberOfSegmentsInString {
}
