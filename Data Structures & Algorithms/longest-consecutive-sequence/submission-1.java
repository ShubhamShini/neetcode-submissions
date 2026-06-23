class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        int ans =1;

        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i]-1)) 
                continue;

            int count =1;

            for(int j = nums[i]+1; ; j++) {
                if(set.contains(j)) {
                    count++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, count);

        }

        return ans;
    }
}
