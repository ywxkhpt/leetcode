package remove_duplicates_from_sorted_array_ii;

//需要在原数组上修改
//需要一个变量记录当前的插入位置
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length <= 2) return A.length;
        int count = 2; //记录当前插入的位置
        for(int i=2;i<A.length;i++){
            if(A[i] != A[count - 2]){
                A[count] = A[i];
                count++;
            }
        }
        return count;
    }
}
