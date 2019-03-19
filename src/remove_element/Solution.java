package remove_element;

//双指针
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length ==0) return 0;
        int res = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] != elem){
                A[res++] = A[i];
            }
        }
        return res;
    }
}
