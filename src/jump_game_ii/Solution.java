package jump_game_ii;

//基于贪婪算法
//将数组分为n段，在每一段内求出这一段为起点，能够跳跃的最大距离
//当到达每一段的末尾的时候 步数加一
public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) return 0;
        int length = A.length;
        int jumps = 0,curEnd = 0,curFarthest = 0;
        for(int i= 0;i < length - 1;i++){
            curFarthest = Math.max(curFarthest,i+A[i]);
            if(i == curEnd){
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
