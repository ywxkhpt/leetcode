package rotate_image;

//顺时针旋转90度 先以对角线为轴调换 再以竖轴调换
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        for(int i=0;i<matrix.length;i++){//对角线
            for(int j=i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<matrix.length;i++){//竖轴
            for(int j=0;j<matrix.length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}
