class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        
        int c = nums[0];
        int b = nums[1];
        int a = (nums[2] + nums[0]);

        for(int i =3;i<nums.length;i++) {
            int curr = Math.max(c,b) + nums[i];
            c = b;
            b = a;
            a = curr;
        }

        return Math.max(a,b);
    }
}
