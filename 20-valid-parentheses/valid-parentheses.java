class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets → push into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Closing bracket
            else {
                
                // If there is nothing to match
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check whether brackets match
                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        // Valid only if nothing is left unmatched
        return stack.isEmpty();
    }
}