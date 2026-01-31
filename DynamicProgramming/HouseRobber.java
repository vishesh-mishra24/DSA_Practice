class Solution {
    int[]memo;
    public int rob(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return helper(nums,nums.length-1);
    }
    private int helper(int[] nums,int i){
        if(i<0)
        return 0;
        if(memo[i]!=-1) return memo[i];
        int rob=nums[i]+helper(nums,i-2);
        int skip=helper(nums,i-1);
        return memo[i]=Math.max(rob,skip);
    }
}
