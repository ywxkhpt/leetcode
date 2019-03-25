package two_sum;

//利用HashMap存储target-numbers[i]和索引
//O(n)
import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        //map里面放 键为target-每个数的结果 值为下标
        //每次放入的时候看是否包含 当前值
        //有的话说明当前值和已包含的值下标的那个元素为需要的结果
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            if(map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i])+1;
                result[1] = i+1;
                break;
            }
            else{
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
}
