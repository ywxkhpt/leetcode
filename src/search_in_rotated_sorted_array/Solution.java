package search_in_rotated_sorted_array;

//二分查找 需要确定是在前半部分 还是在后半部分
public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while(start + 1<end){
            int mid = (end - start)/2 + start;
            if(A[mid] == target) return mid;
            if(A[start] < A[mid]){//前半段有序
                if(A[mid] > target && A[start] <= target){//满足一定在前半段
                    end = mid;
                }else{
                    start = mid;
                }
            }else{//后半段有序
                if(A[mid] < target && target <= A[end]){ //满足一定在后半段
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(A[start] == target) return start;
        if(A[end] == target) return end;
        return -1;
    }
}
