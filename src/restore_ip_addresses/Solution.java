package restore_ip_addresses;

import java.util.ArrayList;
//递归 回溯
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        helper(res,s,0,"",0);
        return res;
    }
    //count记录分段的次数
    private void helper(ArrayList<String> res,String s,int index,String temp,int count){
        if (count > 4) return; //分段超过了4
        if (count == 4 && index == s.length()){//到了末尾并且分为四段
            res.add(temp);
            return;
        }
        for (int i=1;i<4;i++){
            if (index + i > s.length()) break;//超出边界
            String ss = s.substring(index, index + i);
            if ((ss.startsWith("0") && ss.length() > 1) || ( i ==3 && Integer.parseInt(ss) >= 256)) continue;
            helper(res,s,index + i,temp + ss + (count==3 ?"":"."),count+1);
        }
    }
}
