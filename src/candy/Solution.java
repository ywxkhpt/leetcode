package candy;

import java.util.Arrays;

//先都赋值为1 然后从左往右扫描 如果右边大于左边 进行加一操作
//然后从右往左扫描 左边比右边大 candy[i] = Math.max(candy[i],candy[i+1]+1)
public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i=1;i<ratings.length;i++){
            if (ratings[i] > ratings[i-1]) candy[i] = candy[i-1]+1;
        }
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i],candy[i+1]+1);
        }
        int count = 0;
        for (int i : candy) {
            count = count + i;
        }
        return count;
    }
}
