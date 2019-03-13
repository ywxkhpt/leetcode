package binary_tree_level_order_traversal_ii;

//BFS层次遍历 使用队列实现
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list= new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.add(queue.peek().right);
                list.add(queue.poll().val);
            }
            lists.add(list);
        }
        Collections.reverse(lists);
        return lists;
    }
}
