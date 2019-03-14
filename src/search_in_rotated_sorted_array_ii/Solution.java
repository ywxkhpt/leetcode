package search_in_rotated_sorted_array_ii;

//二分查找 由于排序数组经过了旋转 所以需要先判断是前半段 还是后半段递增
//对于 1,1,1,3,1这种情况 无法判断哪半段递增 所以仅仅 将start加1,end减1
public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) return false;
        int length = A.length;
        int start = 0;
        int end = length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target) return true;
            if(A[mid] == A[start] && A[mid] == A[end]){//
                start++;
                end--;
            }else if(A[start] <= A[mid]){ //前半段递增
                if(A[start]<=target && target<= A[mid]){ //判断target会在前半段 还是会在后半段
                    end = mid;
                }else{
                    start = mid;
                }
            }else{//后半段递增
                if(A[mid]<=target && target<= A[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(A[start] == target) return true;
        if(A[end] == target) return true;
        return false;
    }
}
