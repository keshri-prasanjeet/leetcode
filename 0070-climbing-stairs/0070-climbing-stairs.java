class Solution {
    Integer[] memo;
    public int climbStairs(int n) {
        memo = new Integer[n+1];
        return dpClimb(n);
    }

    private int dpClimb(int n){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(memo[n]!=null) return memo[n];
        memo[n] = dpClimb(n - 1) + dpClimb(n-2);
        return memo[n];
    }
}