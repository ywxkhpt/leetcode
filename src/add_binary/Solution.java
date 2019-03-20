package add_binary;

//考虑进位
public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int flag = 0;
        StringBuilder builder = new StringBuilder();
        while(i>=0 || j>=0){
            int sum = flag;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            builder.append(sum % 2);
            flag = sum / 2;
        }
        if(flag != 0) builder.append(flag);
        return builder.reverse().toString();
    }
}
