class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        double nxtfl = 0;
        int ans =0;
        for(int i = n - 1; i >= 0; i--) {
            if(((double)(target - arr[i][0]) / arr[i][1]) > nxtfl) {
                nxtfl = (double)(target - arr[i][0]) / arr[i][1];
                ans++;
            }
        }
        return ans;
    }
}
