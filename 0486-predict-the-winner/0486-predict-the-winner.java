class Solution {
    Integer[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        dp = new Integer[len+1][len+1];
        int res = findWinner(nums, 0, len-1);
        return res >= 0 ? true : false;
    }

    private int findWinner(int[] nums, int start, int end){
        if(start > end) return 0;
        if(start == end) return nums[start];
        if(dp[start][end]!=null) return dp[start][end];
        int diff = Integer.MIN_VALUE;
        int opponentMaxGain = 0;
        int startScore = nums[start];
        opponentMaxGain = findWinner(nums, start+1, end);
        diff = Math.max(diff, startScore - opponentMaxGain);
        int endScore = nums[end];
        opponentMaxGain = findWinner(nums, start, end-1);
        diff = Math.max(diff, endScore - opponentMaxGain);

        return dp[start][end] = diff;
    }
}