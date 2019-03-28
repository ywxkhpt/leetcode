package minimum_path_sum;
//找到从左上角到右下角的路径的最短数字和
//只能往右或往下走
public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                if (i != 0 && j == 0) grid[i][j] += grid[i-1][j];
                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[grid.length -1][grid[0].length -1];
    }
}
