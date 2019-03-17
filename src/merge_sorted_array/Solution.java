package merge_sorted_array;

//如果从前面进行插入排序 则需要移动的步骤较多
//从后面进行插入 不需要移动 因为未被比较的元素不会被覆盖
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m-1;
        int j= n-1;
        int k= m+n-1;
        while(i>=0 &&  j>=0){
            if(A[i] > B[j]){
                A[k] = A[i];
                k--;
                i--;
            }else{
                A[k] = B[j];
                k--;
                j--;
            }
        }
        while(i >= 0){
            A[k] = A[i];
            k--;
            i--;
        }
        while(j >= 0){
            A[k] = B[j];
            k--;
            j--;
        }
    }
}
