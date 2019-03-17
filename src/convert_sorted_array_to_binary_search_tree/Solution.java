package convert_sorted_array_to_binary_search_tree;

//二分搜索 递归
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(right<left)
            return null;
        if(left==right)
            return new TreeNode(nums[left]);
        int mid=left+(right-left+1)/2;
        TreeNode root=new TreeNode(nums[mid]);

        root.left=sortedArrayToBST(nums,left,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,right);

        return root;
    }
}
