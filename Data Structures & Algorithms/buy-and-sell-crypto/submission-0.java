class Solution {
    public int maxProfit(int[] prices) {
        int minTill = Integer.MAX_VALUE;
        int ans =0;

        for(int i=0;i<prices.length;i++) {
            minTill = Math.min(minTill, prices[i]);
            ans = Math.max(ans,prices[i]-minTill);
        }
        return ans;

    }
}
