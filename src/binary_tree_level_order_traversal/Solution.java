package binary_tree_level_order_traversal;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null) return lists;
        helper(root,lists,0);
        return lists;
    }

    private void helper(TreeNode root,ArrayList<ArrayList<Integer>> lists,int level){
        if(root == null) return;
        if(lists.size() <= level){
            ArrayList<Integer> list = new ArrayList<Integer>();
            lists.add(list);
        }
        ArrayList<Integer> list = lists.get(level);
        list.add(root.val);
        helper(root.left,lists,level + 1);
        helper(root.right,lists,level + 1);
    }

}
