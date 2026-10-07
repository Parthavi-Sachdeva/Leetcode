class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();

        int left = 0;
        int right = 0;

        // Find minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        backtrack(s, 0, left, right, 0, new StringBuilder(), ans);

        return ans;
    }

    private void backtrack(String s, int index, int leftRemove,
                            int rightRemove, int open,
                            StringBuilder current, List<String> ans) {

        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && open == 0) {
                String result = current.toString();

                if (!ans.contains(result)) {
                    ans.add(result);
                }
            }
            return;
        }

        char c = s.charAt(index);

        if (c == '(') {

            // Remove '('
            if (leftRemove > 0) {
                backtrack(s, index + 1, leftRemove - 1,
                          rightRemove, open, current, ans);
            }

            // Keep '('
            current.append(c);
            backtrack(s, index + 1, leftRemove,
                      rightRemove, open + 1, current, ans);
            current.deleteCharAt(current.length() - 1);

        } else if (c == ')') {

            // Remove ')'
            if (rightRemove > 0) {
                backtrack(s, index + 1, leftRemove,
                          rightRemove - 1, open, current, ans);
            }

            // Keep ')' only if there is an opening '('
            if (open > 0) {
                current.append(c);
                backtrack(s, index + 1, leftRemove,
                          rightRemove, open - 1, current, ans);
                current.deleteCharAt(current.length() - 1);
            }

        } else {

            // Normal character
            current.append(c);

            backtrack(s, index + 1, leftRemove,
                      rightRemove, open, current, ans);

            current.deleteCharAt(current.length() - 1);
        }
    }
}