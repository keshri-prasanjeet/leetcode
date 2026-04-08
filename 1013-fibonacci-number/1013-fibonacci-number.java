class Solution {
    Integer[] dp;
    public int fib(int n) {
        dp = new Integer[n+1];
        return findFib(n);
    }

    private int findFib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n]!=null) return dp[n];
        return dp[n] = findFib(n-1) + findFib(n-2);
    }
}