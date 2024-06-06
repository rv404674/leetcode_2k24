package medium;

import java.util.HashSet;

class ParentNode {
    public int val;
    public ParentNode left;
    public ParentNode right;
    public ParentNode parent;
};

public class LCA3 {

    // NOTE: Read the question carefully. Root is not given, could have done
    // But in here
    // TC - O(n/2) + O(n/2)
    // Also you dont have the root ParentNode given here as well.
    public ParentNode lowestCommonAncestor(ParentNode p, ParentNode q) {
        if (p == null || q == null)
            return null;

        HashSet<ParentNode> set = new HashSet<>();

        // traverse from p to root
        while (p != null) {
            set.add(p);
            p = p.parent;
        }

        // traverse from q to root.
        while (q != null) {
            if (set.contains(q))
                return q;
            q = q.parent;
        }

        return null;
    }

}
