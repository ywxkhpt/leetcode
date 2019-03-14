package combinations;

//递归加回溯
//分别以i作为第一个 在剩余的 i+1,...,n中寻找k-1个数
///temp记录当前的数 temp在不断变化 当k==0的时候需要向lists添加当前列表
import java.util.*;

public class Solution {
    static ArrayList<ArrayList<Integer>> lists;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>(); //记录当前的数
        helper(temp,n,1,k);
        return lists;
    }

    private void helper(ArrayList<Integer> temp,int n,int start,int k){
        if(k == 0){ //递归基
            lists.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = start;i<=n;i++){
            temp.add(i);
            helper(temp,n,i+1,k-1);
            temp.remove(temp.size() - 1);//回溯
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> combine = solution.combine(4, 2);
        for (ArrayList<Integer> list :
                lists) {
            for (Integer i:
                 list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
