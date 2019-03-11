package pascals_triangle_ii;

import java.util.*;
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex+1];
        row[0] = 1;
        for(int i=1;i<=rowIndex;i++){
            int add = 1;
            for(int j=1;j<=i;j++){
                if(j == i){
                    row[j] = 1;
                }else{
                    int temp = row[j];
                    row[j] = add + row[j];
                    add= temp;
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(row));
        return arrayList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> row = solution.getRow(100);
    }
}
