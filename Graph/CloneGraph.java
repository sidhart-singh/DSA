package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, HashMap<Node, Node> map){
        if(map.containsKey(node))
            return map.get(node);

        // PreOrder : Node -> Neighbors

        // Node:
        // create a new copy for the current node
        Node copy = new Node(node.val);
        // Add current node's copy to the map
        map.put(node, copy);


        // Neighbors : 
        // recursivly traverse the neighbors
        for(Node nei : node.neighbors){
            // add the new node to the current's node copy neighborsList 
            // return from the dfs() call for the neighbor
            copy.neighbors.add(dfs(nei, map));
        }

        // return the copy of the current node
        return copy;
    }
}
