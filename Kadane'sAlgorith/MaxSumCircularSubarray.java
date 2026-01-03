class Solution {
    private int kadane(int[] nums){
        int maxEndingHere=nums[0];
        int maxSoFar=nums[0];
        for(int i=1;i<nums.length;i++){
            maxEndingHere=Math.max(nums[i],maxEndingHere + nums[i]);
            maxSoFar=Math.max(maxSoFar,maxEndingHere);
        }
        return maxSoFar;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int normalMax=kadane(nums);
        if(normalMax<0)
        return normalMax;
        int totalSum=0;
    
    for(int i=0;i<nums.length;i++){
        totalSum+=nums[i];
        nums[i]=-nums[i];
    }
    int invertedMax=kadane(nums);
    int circularMax=totalSum+ invertedMax;
    return Math.max(normalMax,circularMax);
}
}
