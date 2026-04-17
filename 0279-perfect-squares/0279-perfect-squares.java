class Solution {
    Integer[] dp;
    public int numSquares(int n) {
        dp = new Integer[n+1];
        return countPerfectSquareSum(n, (int)Math.sqrt(n));
    }

    private int countPerfectSquareSum(int target, int rootLimit){
        // System.out.println("The target is " + target);
        if(target == 0) return 0;
        if(target <  0) return -1;
        if(dp[target]!=null) return dp[target];
        int minimumNumReq = Integer.MAX_VALUE;
        for(int i=rootLimit;i>=1;i--){
            int square = i*i;
            int res = Integer.MAX_VALUE;
            if(square <= target){
                int newTarget = target-square;
                res = countPerfectSquareSum(target - square, (int)Math.sqrt(newTarget));
            }
            if(res >= 0) {
                minimumNumReq = Math.min(minimumNumReq, res+1);
                dp[target] = minimumNumReq;
            }
        }
        return dp[target];
    }
}