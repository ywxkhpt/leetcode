package spiral_matrix;

//按照循序暴力求解
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i=colBegin;i<=colEnd;i++){//上面一行
                res[rowBegin][i] = num++;
            }
            rowBegin++;
            for(int i=rowBegin;i<=rowEnd;i++){//右边一列
                res[i][colEnd] = num++;
            }
            colEnd--;
            for(int i=colEnd;i>=colBegin;i--){//下面一行 因为是方阵 不需要额外的判断
                res[rowEnd][i] = num++;
            }
            rowEnd--;
            for(int i=rowEnd;i>=rowBegin;i--){//左边一列 因为是方阵 不需要额外的判断
                res[i][colBegin] = num++;
            }
            colBegin++;
        }
        return res;
    }
}
