package unique_binary_search_trees;

//动态规划
//一个有序序列 1 2 3 ... n-1 n
//BST树的总数等于分别以1，2，3，4...n为根的二叉树的数量的和
//以i为根的二叉树的数量F[i] = G[i-1] * G[n-i]
//G[n] = F[1] + F[2] + ...+ F[n]
//     = G[0]*G[n-1] + G[1]*G[n-2] + ...+ G[n-1] * G[0]
//G[0] = 1; G[1] = 1 初始化
public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j=0;j<i;j++){
                G[i] += G[j] * G[i-j-1];
            }
        }
        return G[n];
    }
}
