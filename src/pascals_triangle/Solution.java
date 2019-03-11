package pascals_triangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=1;i<=numRows;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=1;j<=i;j++){
                if(j == i || j == 1){
                    list.add(1);
                }else{
                    list.add(temp.get(j-2) + temp.get(j-1));
                }
            }
            lists.add(list);
            temp = list;
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generate(3);
    }
}
