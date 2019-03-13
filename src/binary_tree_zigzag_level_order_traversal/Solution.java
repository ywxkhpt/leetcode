package binary_tree_zigzag_level_order_traversal;


//树的先序遍历==树的深度优先遍历 深度优先遍历都是先访问左孩子 后访问右孩子
//一个函数记录结点的层数 根据层数决定是从前边插入还是从后面插入
//奇数层插入到前面 偶数层插入到后面
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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
        if(level % 2 == 0){
            list.add(root.val);
        }else{
            list.add(0,root.val);
        }
        helper(root.left,lists,level + 1);
        helper(root.right,lists,level + 1);
    }
}
