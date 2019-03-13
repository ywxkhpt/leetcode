package path_sum_II;

//深度优先遍历
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root == null) return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        helper(root,sum,lists,stack);
        return lists;
    }

    private void helper(TreeNode root, int sum,ArrayList<ArrayList<Integer>> lists,Stack<TreeNode> stack){
        if(root == null) return;
        stack.push(root);
        if(root.left == null && root.right == null && root.val == sum){//到了叶子结点
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(TreeNode node : stack){
                list.add(node.val);
            }
            lists.add(list);
            stack.pop();
            return;
        }
        helper(root.left,sum - root.val,lists,stack);
        helper(root.right,sum - root.val,lists,stack);
        stack.pop();
    }
}
