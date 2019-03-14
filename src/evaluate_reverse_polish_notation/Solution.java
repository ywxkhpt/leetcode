package evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String s:tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
