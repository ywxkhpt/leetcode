package longest_valid_parentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int length = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<length;i++){
            if(s.charAt(i) == '(') stack.push(i);
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        if(stack.isEmpty()) return length;
        int max = 0,end = length;
        while(!stack.isEmpty()){
            max = Math.max(end - stack.peek() - 1,max);
            end = stack.pop();
        }
        max = Math.max(max,end);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses(")(");
    }
}
