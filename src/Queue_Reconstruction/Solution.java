package Queue_Reconstruction;

import java.util.ArrayList;
import java.util.Arrays;

//按身高降序排序 身高相同按第二个数升序排序 之后的排序数组 按照第二个值插入新的数组中
//因为按照身高降序取值 所以新插入得值不会影响前面已经符合要求得值
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
        Arrays.sort(people,(a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] i:people){
            list.add(i[1],i);
        }
        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution solution = new Solution();
        int[][] ints = solution.reconstructQueue(people);
        System.out.println(ints);
    }
}
