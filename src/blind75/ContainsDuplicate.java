package blind75;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer val : nums) {
            if (set.contains(val)) {
                return true;
            }

            set.add(val);
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
