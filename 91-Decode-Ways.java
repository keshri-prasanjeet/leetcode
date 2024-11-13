class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int len = s.length();
        this.dp = new int[len + 1];
        for(int i=0;i<len;i++){
            dp[i] = -1;
        }
        dp[len] =1;
        return countWays(s, 0);
    }

    private int countWays(String s, int index){
        if(dp[index]!=-1) return dp[index];
        if(index > s.length()) return 0;
        if(s.charAt(index) == '0') return 0;

        int ways = 0;
        ways += countWays(s, index+1);

        if(index + 1 < s.length()){
            if(s.charAt(index) == '1' || (s.charAt(index)=='2' && s.charAt(index+1) - '0' <=6)){
                ways += countWays(s, index+2);
            }
        }
        dp[index] = ways;
        return ways;
    }
}