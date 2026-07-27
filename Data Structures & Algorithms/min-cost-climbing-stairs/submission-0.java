class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int b = cost[0];
        int a = cost[1];

        for(int i =2;i<n;i++){
            int curr = cost[i] + Math.min(a,b);
            b= a;
            a = curr;
        }

        return Math.min(a,b);
    }
}
