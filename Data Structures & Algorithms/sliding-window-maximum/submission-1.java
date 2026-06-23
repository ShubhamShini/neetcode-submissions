class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, nums[0]});
        int[] ans = new int[nums.length - k + 1];
        int idx =0;
        for(int i=1;i<k;i++){
            while(!dq.isEmpty() && dq.peekLast()[1]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(new int[]{i, nums[i]});
        }

        ans[idx++] = dq.peekFirst()[1];

        for(int i =k;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()[0]<=i-k){
                dq.pollFirst();
            }
             while(!dq.isEmpty() && dq.peekLast()[1]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(new int[]{i, nums[i]});

            ans[idx++] = dq.peekFirst()[1];
            
        }
        return ans;
    }
}
