package triangle;

//动态规划 依次记录从上到下的路径的最小值
//动态规划的过程中 可以从下往上计算 dp[i]
//[2],      [11]
//[3,4],    [9,10]
//[6,5,7],  [7,6,10]
//[4,1,8,3] [4,1,8,3]
import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for (int i=triangle.size()-1;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
