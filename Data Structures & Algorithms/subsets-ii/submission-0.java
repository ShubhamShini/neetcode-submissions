class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));

        for(int i = index;i<nums.length;i++) {
            current.add(nums[i]);
            backtrack(i+1,nums, current,ans);
            current.remove(current.size()-1);
            while(i<nums.length-1 && nums[i+1] == nums[i])
                i++;
            
        }
    }
}
