package medium;

import java.util.List;

interface NestedInteger {
    // Constructor initializes an empty nested list.
//    public NestedInteger();

    // Constructor initializes a single integer.
//    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


class DepthSum {
    public static int depthSum(List<NestedInteger> nestedList) {
        int totalSum = 0;
        int curLevel = 1;

        for (NestedInteger nestedInteger : nestedList) {
            totalSum += computeRecursively(1, nestedInteger);
        }

        return totalSum;
    }

    public static int computeRecursively(int level, NestedInteger ni) {
        if (ni.isInteger()) {
            return level * ni.getInteger();
        }

        int tempSum = 0;
        for (NestedInteger nestedInteger : ni.getList()) {
            tempSum += computeRecursively(level + 1, nestedInteger);
        }

        return tempSum;
    }
}
