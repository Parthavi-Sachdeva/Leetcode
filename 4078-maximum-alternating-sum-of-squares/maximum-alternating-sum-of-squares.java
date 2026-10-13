

import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int left = 0;
        int right = n - 1;
        long sum = 0;

        while (left <= right) {
            sum += squares[right];
            right--;

            if (left <= right) {
                sum -= squares[left];
                left++;
            }
        }

        return sum;
    }
}
