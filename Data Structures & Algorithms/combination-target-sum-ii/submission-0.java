class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates,ans,new ArrayList<>(),target);
        return ans;
    }

    public void backtrack(int index,int[] candidates, List<List<Integer>> ans, List<Integer> current, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if(target <0 || index == candidates.length) return;

        int a = candidates[index];

        current.add(a);
        backtrack(index +1, candidates, ans, current, target - a);

        current.remove(current.size()-1);
        
        while(index< candidates.length && a == candidates[index]) {
            index++;
        }
        backtrack(index, candidates, ans, current, target);
    }
}
