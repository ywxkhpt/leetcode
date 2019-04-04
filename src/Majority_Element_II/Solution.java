package Majority_Element_II;

import java.util.ArrayList;
//摩尔投票法
//找出数组中出现次数大于n/3的元素
public class Solution {
    ArrayList<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = 0, n = 0, cm = 0, cn = 0;
        for (int a : nums) {
            if (a == m) ++cm;
            else if (a ==n) ++cn;
            else if (cm == 0){
                m = a; cm = 1;
            }else if (cn == 0){
                n = a; cn = 1;
            }else{
                --cm; --cn;
            }
        }
        cm = cn = 0;
        for (int a : nums) {
            if (a == m) ++cm;
            else if (a == n) ++cn;
        }
        if (cm > nums.length / 3) res.add(m);
        if (cn > nums.length / 3) res.add(n);
        return res;
    }
}
