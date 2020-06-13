//utilize stack structure (FILO)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        if (s.length() % 2 != 0) return false;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); 
            }

            if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else if (c == ']' && stack.peek() == '[') 
                    stack.pop();
                else if (c == '}' && stack.peek() == '{') 
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}