public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> counts = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int index = 0;
        
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') { 
                //if another open bracket is found, we need to store the 
                //previous 'res' onto the stack so we can process it later
                //in the meanwhile, clear res to store upcoming letters
                resStack.push(res);
                res = "";
                index++;
            } else if (s.charAt(index) == ']') {
                //if it's a closing bracket, then we process what we have in res
                //by adding it repeatedly to a tmp string builder.
                //putting tmp back into res
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = counts.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            } else {
                //as long as it's a letter, we'll save it and decided later what
                //to do with it.
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }
}