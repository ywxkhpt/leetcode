package Partition_Labels;

import java.util.ArrayList;
import java.util.List;

//第一遍遍历字符串 找到字符串中字符最后出现得位置
//第二遍遍历不断更改最后索引的位置 直到超出最后索引 就找到了一个最小划分
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] index = new int[26];
        for (int i=0;i<S.length();i++){
            index[S.charAt(i) - 'a'] = i;
        }
        int length = S.length();
        int firstIndex = 0;
        while (firstIndex < length){
            int lastIndex = firstIndex;
            for (int i = firstIndex;i < length && i<=lastIndex;i++){
                if (lastIndex < index[S.charAt(i) - 'a']) lastIndex = index[S.charAt(i) - 'a'];
            }
            res.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
    }
}
