package hashtable;

import java.util.ArrayList;
import java.util.List;

class PartitionLabelsSolution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] charMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i) - 'a'] = i;
        }

        int curLen = 1;
        int curFarthestIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curFarthestIndex = Math.max(curFarthestIndex, charMap[c - 'a']);

            if (curFarthestIndex == i) {
                ans.add(curLen);
                curLen = 1;
            } else {
                curLen++;
            }
        }

        return ans;
    }


}


public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabelsSolution solution = new PartitionLabelsSolution();
        String ut1 = "abacdbcfghijlkii";
        System.out.println(solution.partitionLabels(ut1));

        String ut2 = "aaa";
        System.out.println(solution.partitionLabels(ut2));

        String ut3 = "a";
        System.out.println(solution.partitionLabels(ut3));
    }
}
