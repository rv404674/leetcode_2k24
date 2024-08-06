package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Subsets2Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ansSet = new HashSet<>();
        LinkedList<Integer> curPath = new LinkedList<>();
        recursion(0, nums, curPath, ansSet);

        return new ArrayList<>(ansSet);
    }

    public void recursion(int i, int[] nums, LinkedList<Integer> curPath, Set<List<Integer>> ans) {
        // basecase
        if (i == nums.length) {
            // NOTE: curPath is a list (passed by reference)
            // Any addition/subtraction to it would reflect in ansSet. hence make a copy.
            List<Integer> copyPath = new ArrayList<>(curPath); // Make a copy of curPath
            Collections.sort(copyPath);
            ans.add(copyPath);
            return;
        }

        curPath.add(nums[i]);
        recursion(i + 1, nums, curPath, ans);
        curPath.removeLast();

        recursion(i + 1, nums, curPath, ans);
    }
}

public class Subsets2 {
    public static void main(String[] args) {
        Subsets2Solution solution = new Subsets2Solution();

        int[] ut1 = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(ut1));

    }
}
