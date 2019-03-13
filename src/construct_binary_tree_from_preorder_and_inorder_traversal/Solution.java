package construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.*;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length -1,inorder,0,inorder.length -1,map);
    }

    private TreeNode helper(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,HashMap<Integer,Integer> map){
        if(ps > pe || is > ie) return null;//到达叶子结点
        TreeNode root = new TreeNode(preorder[ps]);
        int loc = map.get(preorder[ps]);
        root.left = helper(preorder,ps+1,ps+loc-is,inorder,is,loc -1,map);
        root.right = helper(preorder,ps+loc-is+1,pe,inorder,loc+1,ie,map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        Solution solution = new Solution();
        solution.buildTree(preorder,inorder);
    }
}
