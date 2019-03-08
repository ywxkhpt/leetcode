package jump_game;

//贪婪算法
//maxJump记录当前能够跳的最远位置 在当前点和最远位置之间向前更新 如果能够到达最后则返回true 如果在到达最后之前
//不能前进 则返回fasle
public class Solution {
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) return false;
        int maxJump = 0;
        for(int i = 0;i < A.length;i++){
            maxJump = Math.max(i + A[i],maxJump);
            if(i == maxJump && i != (A.length - 1)){
                return false;
            }
        }
        return true;
    }
}
