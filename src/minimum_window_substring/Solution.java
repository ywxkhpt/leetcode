package minimum_window_substring;

//采用双指针 其中一个记录窗口开始的位置 另一个指针遍历A数组 total记录A的长度
//需要数组记录 T中的字符出现的次数 当数组中T字符出现的次数大于0的时候 total减一
//当total == 0的时候说明T中的字符全部包含，然后判断此时的窗口是否小于最小的窗口 是则更新一下窗口的起始位置
public class Solution {
    public String minWindow(String S, String T) {
        int[] A = new int[128];
        for(char c : T.toCharArray()){
            A[c]++;
        }
        int total = T.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int i=0,j=0;i<S.length();i++){
            if(A[S.charAt(i)]-- > 0){//窗口右边界向右滑
                total--;
            }
            while(total == 0){//窗口左边界向右滑
                if(min > (i - j + 1)){
                    min = i - j + 1;
                    start = j;
                }
                if(++A[S.charAt(j++)] > 0) total++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : S.substring(start,start+min);
    }
}
