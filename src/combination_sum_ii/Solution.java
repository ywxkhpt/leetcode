package combination_sum_ii;

//递归加回溯
//注意元素只能使用一次
//if(i > start && nums[i] == nums[i-1]) continue;深度相同的位置不能够使用相同的元素 去除重复
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return lists;
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        helper(lists,temp,num,target,0);
        return lists;
    }

    private void helper(ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> temp,int[] num, int target,int start){
        if(target < 0){
            return;
        }else if(target == 0){
            lists.add(new ArrayList<Integer>(temp));
        }else{
            for(int i = start;i < num.length;i++){
                if(i > start && num[i] == num[i-1]) continue;//深度相同的位置不能够使用相同的元素 去除重复
                temp.add(num[i]);
                helper(lists,temp,num,target-num[i],i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
