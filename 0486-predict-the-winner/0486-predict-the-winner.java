class Solution {
    Integer[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        dp = new Integer[len+1][len+1];
        int res = findWinner(nums, 0, len-1);
        return res >= 0 ? true : false;
    }

    private int findWinner(int[] nums, int start, int end){
        if(start > end) return Integer.MAX_VALUE;
        if(start > nums.length) return 0;
        if(start == end) {
            System.out.println("both the indicies matched, will return -â¥ " + nums[start]);
            return nums[start];
        }

        if(dp[start][end]!=null) return dp[start][end];

        int diff = Integer.MIN_VALUE;
        int score = 0;

        int scoreStartEnd = nums[start];
        int scoreLastEnd =  nums[end];
        System.out.println("Start is " + scoreStartEnd + " & Last end is " + scoreLastEnd);

        
        System.out.println("Inside startEnd bigger");
        int opponentMax = findWinner(nums, start+1, end);
        System.out.println("Opponent max is: " + opponentMax);
        diff = Math.max(diff, scoreStartEnd - opponentMax);
    
        System.out.println("Inside LastEnd bigger");
        opponentMax = findWinner(nums, start, end-1);
        System.out.println("Opponent max is: " + opponentMax);
        diff = Math.max(diff, scoreLastEnd - opponentMax);

        System.out.println("Diff is " + diff);
        return dp[start][end] = diff;
    }
}