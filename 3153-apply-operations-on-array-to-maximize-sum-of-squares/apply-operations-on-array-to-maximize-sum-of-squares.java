class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] count = new int[31];

        // Count set bits at each position
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }

        long ans = 0;

        // Construct k maximum numbers
        for (int i = 0; i < k; i++) {
            int x = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (count[bit] > 0) {
                    x |= (1 << bit);
                    count[bit]--;
                }
            }

            ans = (ans + 1L * x * x) % MOD;
        }

        return (int) ans;
    }
}