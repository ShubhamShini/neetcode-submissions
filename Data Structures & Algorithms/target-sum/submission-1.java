class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;

        for(int num:nums) {
            sum+=num;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        if((sum+target)%2!=0) return 0;

        int subtarget = (sum+target)/2;

        int[] dp = new int[subtarget+1];

        dp[0] =1;

        for(int num: nums) {
            for(int i = subtarget;i>=num;i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[subtarget];
    }
}
