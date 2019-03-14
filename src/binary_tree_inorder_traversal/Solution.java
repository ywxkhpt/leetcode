package binary_tree_inorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        Solution solution = new Solution();
        List<Integer> integers = solution.inorderTraversal(root);
        for (int i :
                integers) {
            System.out.println(i);
        }
    }
}
