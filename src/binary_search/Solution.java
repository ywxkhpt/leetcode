package binary_search;

//二分查找 如果存在重复的元素 可以找出下边界(第一次出现)和上边界(第一个大于元素的位置)
public class Solution {

    public static int lower_bound(int[] num,int key,int low,int high){
        while (low < high){
            int mid = low + (high - low)/2;
            if (num[mid] >= key){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upper_bound(int[] num,int key,int low,int high){
        while (low < high){
            int mid = low + (high - low)/2;
            if (num[mid] > key){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,2,2,4,4,5};
        int length = num.length;
        System.out.println(lower_bound(num,2,0,length));
        System.out.println(upper_bound(num,2,0,length));
    }
}
