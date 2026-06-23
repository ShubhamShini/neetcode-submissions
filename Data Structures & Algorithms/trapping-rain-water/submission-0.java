class Solution {
    public int trap(int[] height) {
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
    
    int maxi = 0;
    for(int i = 0;i<height.length;i++) {
        maxi = Math.max(maxi, height[i]);
        maxleft[i] = maxi;
    }
    maxi =0;
    for(int j = height.length-1;j>=0;j--) {
        maxi = Math.max(maxi, height[j]);
        maxright[j] = maxi;
    }
    int ans =0;
    for(int i=0;i<height.length;i++) {
        ans += Math.min(maxleft[i],maxright[i]) - height[i];
    }
    return ans;
}
}
