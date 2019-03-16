package longest_consecutive_sequence;

import java.util.HashMap;

//HashMap实现 key为当前数 value为此连续串的大小 r为左邻居的value l为右邻居的value
//情况1：num[i]有一个邻居 更新邻居和自己的value为r或l+1
//情况2: num[i]有两个邻居 更新两个邻居的value为r + l + 1
//情况3:num[i]没有邻居 num[i]的value为1
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<num.length;i++){
            if(map.containsKey(num[i])) continue;
            int l = map.getOrDefault(num[i]-1,0);
            int r = map.getOrDefault(num[i]+1,0);
            int length = 0;
            if(l >0 && r >0){//case 2
                length = l + r + 1;
                map.put(num[i]-l,length);
                map.put(num[i]+r,length);
                map.put(num[i],length);
            }else if(l>0){ //case 1
                length = l + 1;
                map.put(num[i]-l,length);
                map.put(num[i],length);
            }else if(r>0){ //case 1
                length = r + 1;
                map.put(num[i]+r,length);
                map.put(num[i],length);
            }else{ //case 3
                map.put(num[i],1);
            }
        }
        int max=0;
        for (int i: map.values()) {
            max = Math.max(max,i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = new int[]{0,-1};
        Solution solution = new Solution();
        solution.longestConsecutive(num);
    }
}
