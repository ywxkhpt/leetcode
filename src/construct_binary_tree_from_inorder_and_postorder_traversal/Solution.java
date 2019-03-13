package construct_binary_tree_from_inorder_and_postorder_traversal;

//后序 和 中序 重构二叉树
//使用HashMap保存元素和索引的对应关系 中序 后序的最后一个一定是根
import java.util.*;
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1,map);
    }

    private TreeNode helper(int[] inorder,int is,int ie,int[] postorder,int ps,int pe,HashMap<Integer,Integer> map){
        if (ps>pe || is>ie) return null;//说明已经到达叶子节点了 返回null
        TreeNode root = new TreeNode(postorder[pe]);
        int loc = map.get(postorder[pe]);
        root.left = helper(inorder,is,loc-1,postorder,ps,ps+loc-is-1,map);
        root.right = helper(inorder,loc+1,ie,postorder,ps+loc-is,pe -1 ,map);
        return root;
    }
}
