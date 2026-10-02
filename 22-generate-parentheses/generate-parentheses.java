class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve("", 0, 0, n, ans);

        return ans;
    }

    private void solve(String curr, int open, int closed,
                       int total, List<String> ans) {

        // Combination completed
        if(curr.length() == 2 * total) {
            ans.add(curr);
            return;
        }

        // Add '(' if we still have some left
        if(open < total) {
            solve(curr + "(", open + 1, closed, total, ans);
        }

        // Add ')' only when there is an unmatched '('
        if(closed < open) {
            solve(curr + ")", open, closed + 1, total, ans);
        }
    }
}