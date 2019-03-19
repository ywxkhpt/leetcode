package first_missing_positive;

//[98,99,5,-1] 返回1
//采用桶排序的思想 在一趟扫描中找到数组中的元素的桶的位置 并将相应的桶置位
public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length ==0) return 1;
        for(int i=0;i<A.length;i++){
            while(A[i] >0 && A[i] <= A.length && A[A[i] -1] != A[i]){
                int temp = A[A[i] -1];
                A[A[i] -1] = A[i];
                A[i] = temp;
            }
        }

        for(int i=0;i<A.length;i++){
            if(A[i] != i+1){
                return i+1;
            }
        }
        return A.length+1;
    }
}
