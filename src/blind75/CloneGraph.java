package blind75;

import blind75.tree.Node;

import java.util.HashMap;

// keerti - https://www.youtube.com/watch?v=Nki9V1tD5_I
public class CloneGraph {
    public Node cloneUtil(Node node, HashMap<Node, Node> hashMap) {
        // create a new blind75.tree.Node
        Node newNode = new Node(node.val);
        hashMap.put(node, newNode);

        for (Node neigbour : node.neighbors) {
            // if not cloned -> do DFS
            if (!hashMap.containsKey(neigbour)) {
                newNode.neighbors.add(cloneUtil(neigbour, hashMap));
            } else {
                // add to neighbours list
                newNode.neighbors.add(hashMap.get(neigbour));
            }
        }

        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // oldnode -> new blind75.tree.Node
        HashMap<Node, Node> hashMap = new HashMap<>();
        return cloneUtil(node, hashMap);
    }
}