package search_insert_position;

//二分查找
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A ==null || A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){//保证start永远在end的前面
            int mid= (end - start)/2 + start;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(target<=A[start]){
            return start;
        }else if(target<=A[end]){
            return end;
        }else{
            return end + 1;
        }
    }
}
