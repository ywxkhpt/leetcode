package remove_duplicates_from_sorted_array;

//双指针
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length ==0) return 0;
        int res = 1; //目前位置
        int cur = A[0];//记录目前位置的数
        for(int i=1;i<A.length;i++){
            if(A[res-1] == A[i]){
                continue;
            }else{
                A[res++] = A[i];
            }
        }
        return res;
    }
}
