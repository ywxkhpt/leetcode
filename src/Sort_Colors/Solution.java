package Sort_Colors;

//定义两个指针left right
//left前面全是0 right后面全是2
//对数组进行一趟扫描 扫描完成 数组有序
public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0) return;
        int left = 0;
        int index= 0;
        int right = A.length - 1;
        while(index <= right){
            if(A[index] == 0){
                swap(A,left,index);
                left++;
                index++;
            }else if(A[index] == 2){
                swap(A,right,index);
                right--;
            }else{
                index++;
            }
        }
    }

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {1,2,0};
        Solution solution = new Solution();
        solution.sortColors(A);
    }
}
