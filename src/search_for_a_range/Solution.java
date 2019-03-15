package search_for_a_range;

//二分查找 使用start + 1 < end 的方式
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0) return new int[]{-1,-1};
        int start = findFirst(A,target);
        if(start == -1) return new int[]{-1,-1};
        int last = findLast(A,target);
        return new int[]{start,last};
    }

    private int findFirst(int[] A,int target){
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = (end -start)/2 + start;
            if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[start]==target) return start;
        if(A[end]==target) return end;
        return -1;
    }

    private int findLast(int[] A,int target){
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = (end -start)/2 + start;
            if(A[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(A[end]==target) return end;
        if(A[start]==target) return start;
        return -1;
    }
}
