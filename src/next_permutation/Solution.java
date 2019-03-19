package next_permutation;

//找到全排列的 下一个排列
//1,7,2,5,4,3,1
//第一步 从后往前扫描 直到找到num[i] < num[i+1]的num[i] 例子中的2记为firstSmall
//第二步 从后往前扫描 直到找到num[i] > firstSmall的num[i] 例子中的3 记为firstLarge
//第三步 交换firstSmall和记为firstLarge
//结果如下:1,7,3,5,4,2,1
//然后将5，4，2，1进行反转
//最后得到1,7,3,1,2,4,5
//对于 7,5,4,3,2,1,1这种情况 直接将顺序反转
public class Solution {
    public void nextPermutation(int[] num) {
        if(num == null || num.length == 0) return;
        int firstSmall = -1;
        for(int i = num.length - 2;i>=0;i--){
            if(num[i] < num[i+1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1){
            reverse(num,0,num.length-1);
            return;
        }
        int firstLarge = -1;
        for(int i = num.length - 1;i>=0;i--){
            if(num[firstSmall] < num[i]){
                firstLarge = i;
                break;
            }
        }
        swap(num,firstSmall,firstLarge);
        reverse(num,firstSmall+1,num.length-1);
    }

    private void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(int[] num,int i,int j){
        while(i<j){
            swap(num,i,j);
            i++;
            j--;
        }
    }
}
