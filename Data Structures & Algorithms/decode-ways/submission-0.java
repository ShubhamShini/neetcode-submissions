class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        int next1 = 1; // dp[n]
        int next2 = 0; // dp[n+1] (dummy value)

        for (int i = n - 1; i >= 0; i--) {

            int curr = 0;

            if (s.charAt(i) != '0') {

                curr = next1;

                if (i + 1 < n &&
                    (s.charAt(i) == '1' ||
                    (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {

                    curr += next2;
                }
            }

            next2 = next1;
            next1 = curr;
        }

        return next1;
    }
}