class Solution {
    public int maxProduct(int[] nums) {
        int maxprod = nums[0];
        int minprod = nums[0];
        int result = nums[0];

        for(int i=1;i<nums.length;i++) {
            int x = nums[i];

            int oldmax = maxprod;
            int oldmin = minprod;

            maxprod = Math.max(x,Math.max(x*oldmax,x*oldmin));
            minprod = Math.min(x,Math.min(x*oldmax,x*oldmin));

            result = Math.max(result,maxprod);

        }

        return result;
    }
}
