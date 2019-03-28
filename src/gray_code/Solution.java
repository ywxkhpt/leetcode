package gray_code;

import java.util.ArrayList;
//G[i] = i ^ (i/2)
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0;i< 1<<n;i++){
            res.add(i^i>>1);
        }
        return res;
    }
}
