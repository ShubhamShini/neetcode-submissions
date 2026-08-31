class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int jump =1;
        int maxtill =0;
        int a = nums[0];

        for(int i=0;i<nums.length;i++) {
            maxtill = Math.max(maxtill, i + nums[i]);
            if(i == a) {
                jump++;
                a = maxtill;
            }
            if(a == nums.length-1) return jump;
        }
        return jump;
        
    }
}
