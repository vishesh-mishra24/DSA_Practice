class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either extend the current subarray or start new from nums[i]
            currSum = Math.max(nums[i], currSum + nums[i]);

            // Track global maximum
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
