class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        //decode the message
        dp = new Integer[s.length()];
        return countAllDecodings(s, 0, s.length());
    }

    private int countAllDecodings(String s, int idx, int len){
        if(idx == len) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(dp[idx]!=null) return dp[idx];
        int totalDecodeWays = 0;
        totalDecodeWays += countAllDecodings(s, idx+1, len);
        int cur = s.charAt(idx) - '0';
        if(idx+1 < len && (cur == 1 || (cur == 2 && s.charAt(idx+1)-'0' < 7))){
            totalDecodeWays += countAllDecodings(s, idx+2, len);
        }
        return dp[idx] = totalDecodeWays;
    }
}