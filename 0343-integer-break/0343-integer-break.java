class Solution {
    public int integerBreak(int n) {
        //i will maintain an array that will track of smaller intermediate answer
        //dp[0] will be 1 showing the maximum product possible by k nums that sum to 2
        //for the next numbers, i will apply the following formula
        // dp[i] = Math.max(dp[i-1] * 1, (i-2) * 1)
        // i will then simply return dp[target];

        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            for(int j = i;j>=0;j--){
                dp[i] = Math.max(dp[i],Math.max(j * (i-j), j * dp[i-j]));
            }
        }
        return dp[n];
    }
}