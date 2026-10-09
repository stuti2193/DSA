import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            
            // If opening bracket, push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket
            else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }
}