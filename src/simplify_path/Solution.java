package simplify_path;

//使用栈来存储路径
import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        String[] split = path.split("/+");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<split.length;i++){
            if(split[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!split[i].equals(".") && !split[i].equals("")){
                stack.push(split[i]);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res ;
        }
        if(res.length() == 0){
            return "/";
        }
        return res;
    }
}
