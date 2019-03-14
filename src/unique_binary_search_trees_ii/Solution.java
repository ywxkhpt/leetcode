package unique_binary_search_trees_ii;

import java.util.*;
//可以递归实现
//以1，2，3，...，n-1,n为根节点 构造BST树
//以i为根节点为例
//genTrees(start,end)函数返回的以start和end为范围的根节点的列表
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }

    private ArrayList<TreeNode> helper(int start,int end){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end){
            list.add(null);
        }
        ArrayList<TreeNode> left,right;
        for(int i = start;i<=end;i++){
            left = helper(start,i-1);
            right = helper(i+1,end);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
