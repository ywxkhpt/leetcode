package median_of_two_sorted_arrays;
//找中间的第K个数 K由A中取出m1个数 + B中取出m2个数组成
//如果A中的第m1+1个数小于B中的第m2个数 那么A数组中的数取的太少 需要增加A中取的数 左边边界为m1+1
//如果A中的第m1+1个数大于等于B中的第m2个数 那么A数组中的数取的太多 需要减少A中取的数 右边边界为m1
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        if (lengthA > lengthB) return findMedianSortedArrays(B,A);
        int k = (lengthA + lengthB + 1) /2;

        int l = 0;
        int r = lengthA;

        while(l < r){
            int m1 = l + (r - l)/2; //防止溢出 A数组取出m1个数
            int m2 = k - m1; //B数组取出m2个数
            if (A[m1] < B[m2 - 1]){ //A中的数用的太少
                l = m1 + 1;
            }else {//A中的数用的太多
                r = m1;
            }
        }

        int m1 = l;
        int m2 = k - l;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : A[m1 - 1],m2 <= 0 ? Integer.MIN_VALUE : B[m2 - 1]);
        if ((lengthA + lengthB) % 2 == 1) return c1;
        int c2 = Math.min(m1 >= lengthA ? Integer.MAX_VALUE : A[m1],m2 >= lengthB ? Integer.MAX_VALUE : B[m2]);
        return (c1 + c2) * 0.5;
    }

    public static void main(String[] args) {
        int[] A = {};
        int[] B = {1,2};
        Solution solution = new Solution();
        solution.findMedianSortedArrays(A,B);
    }
}
