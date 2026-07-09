class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums,ans,new ArrayList<>(),target);
        return ans;
    }

    public void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> current, int target){
        if(target ==0 ){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(target<0 || index >= nums.length) return;


        current.add(nums[index]);
        backtrack(index,nums,ans,current,target-nums[index]);
        current.remove(current.size()-1);

        backtrack(index+1, nums, ans, current, target);

    }
}
