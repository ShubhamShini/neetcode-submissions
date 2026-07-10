class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,nums, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if(index == nums.length) return;
            current.add(nums[index]);
            backtrack(index+1,nums, current,ans);
            current.remove(current.size()-1);
            while(index<nums.length-1 && nums[index+1] == nums[index])
                index++;
            backtrack(index+1,nums, current,ans);
        
    }
}
