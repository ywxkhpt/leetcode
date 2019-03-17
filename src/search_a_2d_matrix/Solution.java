package search_a_2d_matrix;

//从左上角开始搜索
//每次去掉一行或一列
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0) return false;
        int row = 0;//从第一行
        int col = matrix[0].length - 1;//从最后一列
        while(row < matrix.length && col>=0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}