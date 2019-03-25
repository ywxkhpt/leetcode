package clone_graph;

import java.util.HashMap;

//深度优先 或广度优先 图的遍历
public class Solution {
    HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(node,res);//不要忘记
        for(UndirectedGraphNode neighbor : node.neighbors){
            res.neighbors.add(helper(neighbor));
        }
        return res;
    }
}
