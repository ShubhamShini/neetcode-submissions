class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if(lenS<lenT) return 0;

        int[][] dp = new int[lenS+1][lenT+1];

        for(int i=0;i<lenS;i++) {
            dp[i][0] =1;
        }

        for(int i =1;i<=lenS;i++) {
            for(int j =1;j<= lenT;j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }
}
