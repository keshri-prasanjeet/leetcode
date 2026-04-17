class Solution {
    Integer[] dp = new Integer[10001];
    public int numSquares(int n) {
        if(n==0) return 0;
        if(dp[n]!=null) return dp[n];

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(n >= (i*i)){
                min = Math.min(min, 1+numSquares(n - (i*i)));
            }
        }

        return dp[n] = min;
    }
}